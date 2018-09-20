const mongoose = require('mongoose');

const chat = mongoose.Schema({
  
  room_name: String
  , members: [{
      id: String
    , name: String
    , point: Number
  }]
  , chat: [{
    from: {
      id: String
      , name: String
      , point: Number
    },
    message: String
  }]
});

module.exports = mongoose.model("chat", chat);
