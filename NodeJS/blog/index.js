const express = require('express');
const bodyParser = require('body-parser');
const morgan = require('morgan');
const session = require('express-session');
const path = require('path');

// 서버 생성
const app = express();

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
app.listen(3000, () => {
  console.log("http://localhost:3000 번에서 실행 중");
});
