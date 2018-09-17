const http = require("http");
const fs = require("fs");
//웹 서버 생성
const server = http.createServer((req, res) => {
  res.writeHead(200, {"Content-Type": "text/html"}); //html데이터를 보내주겟다는 뜻.
  fs.readFile("./hello.html", "utf-8", (error, data) => {
    if( !error ){
      res.end(data);
    }
    else {
      console.log(error);
    }
  })
});

// 웹 서버 실행
server.listen(3000, () => {
  console.log("http://localhost:3000 을 서버가 실행되었습니다");
});
