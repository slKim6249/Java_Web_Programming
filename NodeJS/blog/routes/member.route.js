const express = require("express");
const router = express.Router();

const mongo = require("../mongodb/mongo-client");
const member = require("../mongodb/schema/member");

const fs = require("fs");

router.get('/login', (req, res) =>{
    fs.readFile('./view/member/login.html', 'utf-8', (error, data) => {
        if( !error ) {
            res.type('text/html');
            res.send(data);
        }
    });
});

router.post('/login', (req, res) =>{

    const id = res.body.id;
    const password = req.body.password;

    member.find({ id: id, password: password }, (error, results) => {
        if ( !error && results ) {
            console.log(results);
            if ( id == results.id && password == results.password ) {
                req.session.USER = results;
                res.redirect('/blog');
            }
        }
    })
    
    // const memberParams = req.body;
    // memberParams.point = 100;

    // const memberData = new member(memberParams);
    // memberData.save();

    // res.redirect('/member/login');

});

router.get('/regist', (req, res) =>{
    fs.readFile('./view/member/regist.html', 'utf-8', (error, data) => {
        if( !error ) {
            res.type('text/html');
            res.send(data);
        }
    });
});

router.post('/regist', (req, res) =>{

});

exports.router = router;