const http = require('http');
const fs = require('fs');

// 웹 서버 생성
const server = http.createServer((req, res) => {
  res.writeHead(200, {"Content-type" : "text/html"})
  fs.readFile("./hello.html", "utf-8", (error, data) => {
    if ( !error ) {
      res.end(data);
    }
    else {

    }
  })
});

// 웹 서버 실행
server.listen(3000, () => {
  console.log("http://localhost:3000 으로 서버가 실행되었습니다.");
});
