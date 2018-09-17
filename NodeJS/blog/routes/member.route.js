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
        if ( !error && results[0] ) { // 0번이 Undifined라면, MonggoDB는 배열로 들어간다. 0번부터 들어간다.
            console.log(results);
           // if ( id == results.id && password == results.password ) {
                req.session.USER = results[0];
                res.redirect('/blog');
           // }
        }
        else {
            res.redirect('/member/login'); // login 실패시 다시 login창으로
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