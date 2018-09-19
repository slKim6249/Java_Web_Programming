const fs = require('fs');
const os = require('os');

// 파일 작성
fs.writeFile("./cpus.txt", os.cpus(), "utf-8", (error) => {
  // true : 데이터가 존재할 경우
  // false : 0, undefined, "", null
  if ( !error ) {
    console.log("파일 작성 완료!");
  }
  else {
    console.log(error);
  }
})
