const mongoose = require('mongoose');

module.exports = function() {

  mongoose.connect("mongodb://localhost:27017/blog", (error) => {
      if ( error ) {
        console.log("MongoDB 접속 실패");
      }
      else {
        console.log("MongoDB 접속 성공");
      }
  });

}();
