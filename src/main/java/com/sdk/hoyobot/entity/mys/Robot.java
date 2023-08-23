package com.sdk.hoyobot.entity.mys;

import lombok.Data;

@Data
public class Robot {
//    {
//        "template": {
//        "id": "bot_ea9d3xxxxxx9",
//                "name": "测试",
//                "desc": "测试机器人",
//                "icon": "",
//                "commands": [
//        {
//            "name": "/重置",
//                "desc": "重置会话"
//        }
//                ]
//    },
//        "villa_id": 100001
//    }

    private String villa_id;
    private Template template;
}
