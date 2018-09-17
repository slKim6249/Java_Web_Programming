const express = require("express");
const bodypParser = require("body-parser");
const morgan = require("morgan");
const multipart = require("connect-multiparty");
//서버 생성
const app = express(); //리퀘스트가 가면 얘부터 본다. 서버 생성되있으면 무시.

//Http request Logger
app.use(morgan("combined")); //로그 설정

//body -parser Middleeware
//form데이터가 있다면 request body에 넣어주겠다는 설정.
app.use(bodypParser.urlencoded({extended: false}));

app.use(multipart({ uploadDir:__dirname + "/multipart"}))

//Static MiddleeWare
app.use("/static", express.static(__dirname + "/static"));
app.use("/jquery", express.static(__dirname + "/node_modules/jquery/dist"));

// URL Routing
app.use("/emp", require("./routes/emp.route.js").router);
app.use( require("./routes/index.route.js").router );
app.use("/blog", require("./routes/blog.route.js").router);
app.use("/fileupload", require("./routes/blog.route.js").router);
app.use("/member", require("./routes/member.route.js").router);

app.use((req,res) => {  // 슬래시 주소 위에서부터 찾다가 여긴 무조건 들린다. 아무것도 못찾고 여기까지 왓기 때문에
                        // 사용자가 입력한 url찾순서대로 찾는데 위에서부터 그러므로 이 코드가 위에있다면 무조건 404만 뜬다.
                        // 리스폰이 나갔냐 안나갔냐를가지고 다음으로 진행 할지 말지를 결정한다
                        // 그래서 페이지 라우터에서는 순서가 엄청 중요하다.
  res.type("text/html");
  res.sendStatus(404);
});



// 서버 실행
app.listen(3000, () => {
  console.log("htpp://localhost:3000 번에서 실행 중");
});
