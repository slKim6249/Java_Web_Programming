const mongoose = require('mongoose');
const member = require('./member');

const post = mongoose.Schema({
  title: String
  , content: String
  , tags: [String]
  , files: [String]
  , author: {
    id: String
    , name: String
    , point: Number
  }
});

module.exports = mongoose.model("post", post);
