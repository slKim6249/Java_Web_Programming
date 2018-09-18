const express = require("express");
const fs = require("fs");
const ejs = require("ejs"); // 이게 있어야 el, jstl같은 것들을 쓸 수 있다.
const router = express.Router();
const multipart = require("connect-multiparty");

const mongo = require("../mongodb/mongo-client");
const post = require("../mongodb/schema/post");

// http:localhost:3000/blog로 들어 오면
router.get("/", (req, res) => {
  fs.readFile("./view/list.html", "utf-8", (error, data) => {
    if ( !error ){

      post.find({"tags": "123"}, (error, results) => {
        console.log(results);
        res.type("text/html");
        res.send(ejs.render(data, {postList: results}));
    });

    }
    else{
      console.log(error);
    }
  });
});

router.get("/post", (req, res) => {
  fs.readFile("./view/write.html", "utf-8", (error, data) => {
    if ( !error ){
      res.type("text/html");
      res.send(data);
    }
  });
});

router.post("/post", multipart({ 
    uploadDir : './static/uploadFiles'
  }) , (req, res) => {


  console.log(req.files);

  const params = req.body;
  console.log(params);
  params.files = [];

  if ( typeof req.files.file[Symbol.iterator] === 'function' ) {
    for ( let file of req.files.file ) {
      fillFiles(req.files.file.path);
    }
  }
  else {
    fillFiles(req.files.file.path);
  }

  function fillFiles(filePath) {
    filePath = filePath.substring(filePath.lastIndexOf('\\')+1);
    params.files.push(filePath);
  }

  for ( let file of req.files.file ) {
    let filePath = file.path;
    filePath = filePath.substring(filePath.lastIndexOf('\\')+2);
    params.files.push(filePath);
  }

  const postData = new post(params);
  postData.save();

  res.redirect("/blog");
});

router.get("/fileupload", (req, res) => {
  fs.readFile("./view/fileupload.html", "utf-8", (error, data) => {
    if ( !error ){
      res.type("text/html");
      res.send(data);
    }
  });
});

router.post("/fileupload", (req, res) => {
  const params = req.body;
  console.log(params);

  console.log(res.file);

  res.redirect("/blog");

});
                
exports.router = router;
