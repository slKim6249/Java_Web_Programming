const express = require('express');
const router = express.Router();
const mongo = require('../mongodb/mongo-client');
const member = require('../mongodb/schema/member');

router.get("/login", (req, res) => {
  res.render("member/login");
});

router.post("/login", (req, res) => {
  const id = req.body.id;
  const password = req.body.password;

  member.find({ id: id, password: password }, (error, results) => {
    if ( !error && results[0] ) {
      req.session.USER = results[0];
      res.redirect("/blog")
    }
    else {
      res.redirect("/member/login");
    }
  });

});

router.get("/regist", (req, res) => {
  res.render("member/regist");
});

router.post("/regist", (req, res) => {
  const memberParams = req.body;
  memberParams.point = 100;

  const memberData = new member(memberParams);
  memberData.save();

  res.redirect("/member/login");
});

router.get("/logout", (req, res) => {
  req.session.destroy();
  res.redirect("/member/login");
});

exports.router = router;
