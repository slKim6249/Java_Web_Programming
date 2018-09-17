const express = require("express");
const router = express.Router();

const data = [ //DB에 있는 데이터라고 생각하기.
  {id: 1, name:"KSH", team: "DEV"}
  , {id:2, name:"JHKIN", team: "DEV" }
  , {id:3, name: "CWJUNG", team: "R&D"}
];

//:id는 스프링의 {id}와 같은 의미다.
router.get("/:id", (req, res) => { //app.get의 역할을 대신한다. router.get이
  let id = req.params.id; // id에 있는 값을 가져온다.
  let emp;

  for( let eachEmp of data ){ //in은 index를 줌, of는 데이터를 준다.
    if( eachEmp.id == id ){
      emp = eachEmp
      break;
    }
  }

  if ( emp ){ // emp에 데이터가 있다면 true
    res.type("text/html");
    res.send(`
      <html>
        <head>
          <title>${emp.name}</title>
        </head>
        <body>
          <h1>${emp.name}</h1>
          <h4>${emp.team}</h4>
        </body>
      </html>
    `);
  }
  else {
    res.type("text/html");
    res.sendStatus(404);
  }

});


exports.router = router; //내가만든 라우터파일를 외부에서 사용할 수 있게 외부로 노출시켜 준다. 그 이름을 router로 하겠다.
