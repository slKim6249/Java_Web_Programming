const express = require('express');
const router = express.Router();

const data = [
  {id: 1, name: "MCJANG", team: "DEV"}
  , {id: 2, name: "JHKIM", team: "DEV"}
  , {id: 3, name: "CWJUNG", team: "R&D"}
];

// :id ==> {id}
router.get("/:id", (req, res) => {
  let id = req.params.id;
  let emp;

  for ( let eachEmp of data ) {
    if ( eachEmp.id == id ) {
      emp = eachEmp;
      break;
    }
  }

  if ( emp ) {
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

exports.router = router;
