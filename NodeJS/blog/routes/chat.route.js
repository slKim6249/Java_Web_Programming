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

    res.render("chat/chat2", {
        'data': {
            'room_name': roomName,
            'me': user
        }
    });
})

router.get("/chat/:roomName", (req,res) => {
    const roomName = req.params.roomName;
    const user = req.session.USER;

    chat.find({'room_name': roomName}, (error, results) => {
        const oneChatRoom = new chat(results[0])
        oneChatRoom.members.push(me)
        oneCharRoom.save();

        res.render("chat/chat2", {
            'data': {
                'room_name': roomName,
                'me': me
            }
        });
    })
});

exports.router = router;