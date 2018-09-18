const mongo = require("mongoose");
const member = require("./member");

const post = mongo.Schema({
  //save 시킬것들의 필드를 적는다
  title: String,
  content: String,
  tags: [String],
  files: [String],
  auther: {
    id: String,
    name: String,
    point: Number
  }
});
  //post에 title, content, tags를 넣어서 쓸 수 있다.
  module.exports = mongo.model("post", post);
