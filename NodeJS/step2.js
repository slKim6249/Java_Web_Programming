const fs = require("fs");
const os = require("os");

//파일작성
//cpus.txt 에다가 os.cpus 내용을 쓴다.
fs.writeFile( "./cpus.txt", os.cpus, "utf-8", (error) => {

  //true : 데이터가 존재 할 경우
  //false : 0, undefined, "", null

  if(!error){
    console.log("파일 작성 완료");
  }
  else {
    console.log(error);
  }
} );
