const express = require("express");
const router = express.Router();

router.get("/", (req, res) => { // get방식의 리퀘스트를 받겠다.
  res.type("text/html");
  res.write("<h1>성공! Welcome to Index Page</h1>");
  res.send();
});

router.get("/bye", (req, res) => {
  res.type("text/html");
  res.send("<h1>성공! Goobye, See U Again~</h1>");
});


exports.router = router;
