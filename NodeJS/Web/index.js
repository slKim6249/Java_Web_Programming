const http = require('http');
const fs = require('fs');
const url = require('url');

// 웹 서버 생성
const server = http.createServer((req, res) => {
  res.writeHead(200, {"Content-type" : "text/html"});

  console.log(req.url);
  const path = url.parse(req.url).pathname;
  console.log(path);

  if ( path == "/index" && req.method == "GET" ) {
    fs.readFile("../hello.html", "utf-8", (error, data) => {
      if ( !error ) {
        res.end(data);
      }
      else {}
    });
  }
  else if ( path == "/login" && req.method == "GET" ) {
    fs.readFile("./view/login.html", "utf-8", (error, data) => {
        if ( !error ) {
          res.end(data);
        }
        else {}
    });
  }
  else if ( path == "/login" && req.method == "POST" ) {
    // Form Param 얻어오기
    req.on("data", (data) => {
      res.end(data.id + " / " + data.password);
    });
  }
  else {
    res.writeHead(404, {"Content-Type" : "text/html"});
    res.end("404 Error");
  }

});

// 웹 서버 실행
server.listen(3000, () => {
  console.log("http://localhost:3000 으로 서버가 실행되었습니다.");
});
