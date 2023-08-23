package com.sdk.hoyobot.entity.mys;

import lombok.Data;

import java.util.HashMap;
import java.util.List;

@Data
public class Template {

//    {
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

    private String id;
    private String name;
    private String desc;
    private String icon;
    private List<Commands> commands;
}
