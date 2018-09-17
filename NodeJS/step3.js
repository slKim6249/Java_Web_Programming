const fs = require("fs");

//파일 읽기
fs.readFile("./cpus.txt", "utf-8", (error, data) => {
  if ( !error ){
    console.log(data);
  }
  else {
    console.log(error);
  }
})
