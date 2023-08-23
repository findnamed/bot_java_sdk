package com.sdk.hoyobot.entity.mys;

import lombok.Data;

@Data
public class SendMessage {
//    {
//        "content": "",      // 消息内容
//            "from_user_id": 0,  // 发送者 id
//            "send_at": 0,       // 发送时间的时间戳
//            "room_id": 0,       // 房间 id
//            "object_name": 1,   // 目前只支持文本类型消息
//            "nickname": "",     // 用户昵称
//            "msg_uid": "",      // 消息 id
//            "bot_msg_id": "",   // 如果被回复的消息从属于机器人，则该字段不为空字符串
//            "villa_id": 0       // 大别野 id
//    }
    private String content;
    private String from_user_id;
    private String send_at;
    private String room_id;
    private String object_name;
    private String nickname;
    private String msg_uid;
    private String bot_msg_id;
    private String villa_id;

}
