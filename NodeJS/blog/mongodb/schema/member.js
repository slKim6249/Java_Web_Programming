const mongo = require("mongoose");

const member = mongo.Schema({
  //save 시킬것들의 필드를 적는다
  id: String,
  password: String,
  name: String,
  point: Number
});
  
  module.exports = mongo.model("member", member);
