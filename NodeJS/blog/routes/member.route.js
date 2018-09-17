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

module.exports = router;