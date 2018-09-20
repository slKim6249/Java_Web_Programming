const express = require("express");
const router = express.Router();

const mongo = require("../mongodb/mongo-client");
const chat = require("../mongodb/schema/chat");

/*
 * 채팅 방 조회
 */
router.get("/", (req, res) => {
    chat.find({}, (error, results) => {
        res.render("chat/chat", {rooms: results});
    })
    res.render("chat/chat");
})

router.post("/", (req, res) => {
    const room_name = req.body.room_name;
    const user = req.session.USER;

    const chatData = new chat({
        'room_name': room_name,
        members: [user],
        chat: []
    });

    chatData.save();

    res.render("<h1>채팅방이 개설되었습니다.</h1>");
})

exports.router = router;