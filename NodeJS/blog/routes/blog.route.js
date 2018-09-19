const express = require('express');
const mongo = require('../mongodb/mongo-client');
const post = require('../mongodb/schema/post');
const multipart = require('connect-multiparty');
const fs = require('fs');
const router = express.Router();

router.get("/", (req, res) => {
  const posts = post.find({}, (error, results) => {
    res.render("list", {postList: results});
  });
});

router.post("/image/upload", multipart( {uploadDir: './static/uploadFiles'} ), (req, res) => {
  console.log(req.files);

  const fileName = function(filePath) {
    return filePath.substring( filePath.lastIndexOf("\\") + 1);
  }(req.files.upload.path);

  res.type("application/json");
  res.send(JSON.stringify({
    uploaded: true
    , url: "/static/uploadFiles/" + fileName
  }));
});

router.get("/post/:id", (req, res) => {
  const id = req.params.id;

  const objectId = require("mongoose").Types.ObjectId;
  post.find({ _id: new objectId(id) }, (error, results) => {
    if ( !error && results[0] ) {
      res.render("detail", {post: results[0]});
    }
  });
});

router.get("/post/tag/:tag", (req, res) => {
  const tag = req.params.tag;
  post.find({tags: tag}, (error, results) => {
    if( !error && results ) {
      res.render("list", {postList: results});
    }
  });
});

router.get("/post", (req, res) => {
    res.render("write");
});

router.post("/post", multipart( {uploadDir: './static/uploadFiles'} ), (req, res) => {
  const params = req.body;
  params.author = req.session.USER;
  const files = req.files;
  params.files = [];

  // 여러개 파일 업로드
  if ( typeof files.file[Symbol.iterator] === "function" ) {
    for ( let file of files.file ) {
      fillFiles(file.path);
    }
  }
  // 한개 파일 업로드
  else {
    if ( files.file.size > 0 ) {
      fillFiles(files.file.path);
    }
    else {
      fs.unlink(files.file.path);
    }
  }

  function fillFiles(filePath) {
    filePath = filePath.substring( filePath.lastIndexOf("\\")+1 );
    params.files.push(filePath);
  }

  console.log(params);
  console.log(files);

  const postData = new post(params);
  postData.save();

  res.redirect("/blog");
});

router.get("/modify/:id", (req, res) => {
  const ObjectId = require("mongoose").Types.ObjectId;
  post.find({ _id: new ObjectId(req.params.id) }, (error, results) => {
    if ( !error && results[0] ) {
      res.render("modify", { post: results[0] });
    }
    else {
      res.redirect("/post");
    }
  });
});

router.post("/modify/:id", multipart( {uploadDir: './static/uploadFiles'} ), (req, res) => {
  const id = req.params.id;
  const ObjectId = require("mongoose").Types.ObjectId;

  post.find({ _id: new ObjectId(id) }, (error, results) => {
    if ( !error && results[0] ) {
      const postData = new post(results[0]);
      const postBody = req.body;

      postData.title = postBody.title;
      postData.content = postBody.content;
      postData.tags = postBody.tags;

      postData.save();
    }
    res.redirect("/blog/post/" + id);
  });
});

router.get("/delete/:id", (req, res) => {
  const id = req.params.id;
  const ObjectId = require("mongoose").Types.ObjectId;

  post.deleteOne({_id: new ObjectId(id)}, (error) => {
    res.redirect("/blog");
  });
});

exports.router = router;
