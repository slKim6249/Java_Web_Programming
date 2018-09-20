const express = require('express');
const bodyParser = require('body-parser');
const morgan = require('morgan');
const session = require('express-session');
const path = require('path');

const http = require("http");

// 서버 생성
const app = express();

// express와 http 연동
const server = http.createServer(app);

app.set('view engine', 'ejs');
app.set('views', path.join(__dirname, 'view'));

// Session 사용 설정
app.use(session({
  secret: "hello blog"
  , resave: false
  , saveUninitialized: true
}));

// Http request logger
app.use(morgan("combined"));

// body-parser Middleware
app.use(bodyParser.urlencoded({extended: false}));

// Static Middleware
app.use("/static", express.static(__dirname + "/static"));
app.use("/jquery", express.static(__dirname + "/node_modules/jquery/dist"));
app.use("/editor", express.static(__dirname + "/node_modules/@ckeditor/ckeditor5-build-classic/build"));

app.use((req, res, next) => {
  res.locals.session = req.session.USER;
  next();
});

// URL Routing - routing middleware
app.use("/member", require("./routes/member.route.js").router);

app.use((req, res, next) => {
  if ( !req.session.USER ) {
    res.redirect("/member/login");
    return;
  }
  next();
});

app.use("/emp", require("./routes/emp.route.js").router);
app.use("/blog", require("./routes/blog.route.js").router);
app.use("/chat", require("./routes/chat.route.js").router);
app.use(require("./routes/index.route.js").router);

app.use((req,res) => {
  res.type("text/html");
  res.sendStatus(404);
});

// app.use( (req, res) => {
//
//   let id = req.query.id;
//   let password = req.query.password;
//
//   res.type("text/html");
//   res.send(`
//     <h1>Hello, Express</h1>
//     <p>${id}</p>
//     <p>${password}</p>
//     `);
// });

// 서버 실행
server.listen(3000, () => { // app.listen -> server.listen은 socket.io
  console.log("http://localhost:3000 번에서 실행 중");
});


// socket 서버 생성
const socket = require("socket.io");
const io = socket.listen(server);

const mongo = require("./mongodb/mongo-client");
const chat = require("./mongodb/schema/chat");

const connectMember = [];

// socket ==> Socket.io에 접속한 객체
io.sockets.on('connection', (socket) => {
// 1.접속자를 채팅방에 포함시키기
  socket.on('enter_room', (data) => {
    socket.join(data.roomName);
    io.sockets.in(data.roomName).emit('welcome', { // in을 사용하면 그 방안에서만 사용 가능
      message: '${data.me.name}님이 입장하셨습니다.'
  })

  connectMember.push({
    socketId: socket.id,
    roomName: data.roomName,
    member: data.me
  });

  chat.find({'room_name': data.roomName}, (error, results) => {
    const members = results[0].members;
    io.sockets.in(data.roomName).emit('getMemberList', {members: members});
  })

});

// 사용자가 채팅방을 나갔을 때 실행됨.
//  (새로고침, 브라우저 종료, 다른 url로 이동)
socket.on('disconnect', () => {
    console.log('로그아웃');
    for ( let member of connectMember ) {
      if( member.socketId == socket.id ) {
        let roomName = member.roomName;
        let user = member.member;
        io.sockets.in(roomName) .emit('welcome', {
          message: '${user.name}님이 나가셨습니다.'
        });
        delete connectMember[member];
        chat.update({room_name: roomName}, { $pull: { members: { id: user.id } } }
                          , { safe: true }
                          , ( error, obj ) => {
                            if ( !error ) {
                              chat.find({'room_name': data.roomName}, (error, results) => {
                                const members = results[0].members;
                                io.sockets.in(data.roomName).emit('getMemberList', {members: members});
                              })
                            }
                          });
      }
    }
  });
})

// 2.채팅 전송받고, 모두에게 전달하기
socket.on('send', (data) => {
  io.sockets.in(data.roomName).emit('receive', data);
})