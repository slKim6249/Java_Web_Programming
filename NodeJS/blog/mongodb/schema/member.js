const mongoose = require('mongoose');

const member = mongoose.Schema({
  id: String
  , password: String
  , name: String
  , point: Number
});

module.exports = mongoose.model("member", member);
