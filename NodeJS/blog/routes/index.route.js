const express = require('express');
const router = express.Router();

router.get("/", (req, res) => {
    res.type("text/html");
    res.write("<h1>Welcome to index Page</h1>");
    res.send();
});

router.get("/bye", (req, res) => {
  res.type("text/html");
  res.send("<h1>Goodbye, See you again!</h1>");
});

exports.router = router;
