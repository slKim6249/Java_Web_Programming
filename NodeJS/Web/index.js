const http = require("http");
const fs = require("fs");
const url = require("url"); // url 구분해주는 모듈

//웹 서버 생성
const server = http.createServer((req, res) => {
  res.writeHead(200, {"Content-Type": "text/html"}); //html데이터를 보내주겟다는 뜻.

  console.log(req.url);
  const path = url.parse(req.url).pathname; //http://localhost:3000 /~~이후에 적는 값이 pathname이다. 앞부분 다 빼고 가져옴
  console.log(path);

  if( path == "/index" && req.method == "GET"){
    fs.readFile("../hello.html", "utf-8", (error, data) => {  // hello.html 은 상위폴더에 있음. 그래서 ../ 로 가져옴.
      if( !error ){
        res.end(data);
      }
      else {}
    })
  }
  else if ( path == "/login" && req.method == "GET") {
    fs.readFile("./view/login.html", "utf-8", (error, data) => {  // hello.html 은 상위폴더에 있음. 그래서 ../ 로 가져옴.
      if( !error ){
        res.end(data);
      }
      else {}
    })
  }
  else if ( path == "/login" && req.method == "POST") {
    // Form Param 얻어오기
    req.on("data", (data) => { //데이터 이벤트가 발생되면 폼 파라미터를 가져와서
      console.log(data.toString());
      res.end(data.id + " / " + data.password);
    });
  }
  else {
    res.writeHead(404, {"Content-Type": "text/html"});
    res.end("404 Error");
  }


});

// 웹 서버 실행
server.listen(3000, () => {
  console.log("http://localhost:3000 을 서버가 실행되었습니다");
});
