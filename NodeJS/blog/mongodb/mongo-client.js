const mongo = require("mongoose");

//몽고디비와 연동시켜주는 모듈 만든다.
module.exports = function(){              //연결을 실패했을 때
  mongo.connect("mongodb://localhost:27017/blog", (error) => {
    if( error ){
      console.log("MongoDB 접속 실패");
    }
    else{
      console.log("MongoDB 접속 성공");
    }
  });
}();
//위에 괄호 즉시 실행함수. 
