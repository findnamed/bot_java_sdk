package com.sdk.botjavasdk.components;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

//解析事件回调
@Component
public class EventClass {

    private static int type;
    private static  String id;
    //事件创建时间的时间戳
    private static long created_at;
    //事件回调时间的时间戳
    private static long send_at;
    //robot中的参数
    private static String bot_name;//机器人名字
    private static String bot_icon;
    private static String bot_id;
    private static String bot_desc;
    private static Object bot_commands;
    //具体事件参数
    private static long data_room_id;  //房间id
    private static int data_object_name;
    private static String data_nickname;
    private static String data_send_at;//消息发送时间戳
    private static String data_msg_uid;//消息id
    private static long data_from_user_id;
    private static int data_villa_id; //大别野id
    private static String data_text;//获取用户发送的内容
    private static String data_name;//获取发送者的姓名
    private static String data_name_id;//获取发送者的id
    //总参数解析
    public void evented(JSONObject params){
        robotparams(params.getJSONObject("robot"));
        extenddataparams(params.getJSONObject("extend_data"));
        this.type=params.getInteger("type");
        this.id=params.getString("id");
        this.created_at=params.getInteger("created_at");
        this.send_at=params.getInteger("send_at");
    }

    //robot参数解析
    public void robotparams(JSONObject params){
        JSONObject template=params.getJSONObject("template");
        this.bot_name=template.getString("name");
        this.bot_icon=template.getString("icon");
        this.bot_id=template.getString("id");
        this.bot_desc=template.getString("desc");
        this.bot_commands=template.get("commands");

    }
    //事件的具体数据解析
    public void extenddataparams(JSONObject params){
        JSONObject eventdata=params.getJSONObject("EventData");
        JSONObject sendmessage=eventdata.getJSONObject("SendMessage");
        this.data_room_id=sendmessage.getInteger("room_id");
        this.data_object_name=sendmessage.getInteger("object_name");
        this.data_nickname=sendmessage.getString("nickname");
        this.data_send_at=sendmessage.getString("send_at");
        this.data_msg_uid=sendmessage.getString("msg_uid");
        this.data_from_user_id=sendmessage.getInteger("from_user_id");
        this.data_villa_id=sendmessage.getInteger("villa_id");
        String content=sendmessage.getString("content");
        JSONObject js= JSON.parseObject(content);
        JSONObject data_content=js.getJSONObject("content");
        this.data_text=data_content.getString("text");
        JSONObject data_user=js.getJSONObject("user");
        this.data_name=data_user.getString("name");
        this.data_name_id=data_user.getString("id");
        //content未解析完

    }

    public static class Main {
        //解析参数
        public static void main(JSONObject params) {
            EventClass ev=new EventClass();
            ev.evented(params);
        }
        public static int type(){
            return EventClass.type;
        };
        public static  String id(){
            return EventClass.id;
        };
        //事件创建时间的时间戳
        public static long created_at(){
            return EventClass.created_at;
        };
        //事件回调时间的时间戳
        public static long send_at(){
            return EventClass.send_at;
        };
        //robot中的参数
        public static String bot_name(){
            return EventClass.bot_name;
        };
        public static String bot_icon(){
            return EventClass.bot_icon;
        };
        public static String bot_id(){
            return EventClass.bot_id;
        };
        public static String bot_desc(){
            return EventClass.bot_desc;
        };
        public static Object bot_commands(){
            return EventClass.bot_commands;
        };
        //具体事件参数
        public static long data_room_id(){
            return EventClass.data_room_id;
        };
        public static int data_object_name(){
            return EventClass.data_object_name;
        };
        public static String data_nickname(){
            return EventClass.data_nickname;
        };
        public static String data_send_at(){
            return EventClass.data_send_at;
        };
        public static String data_msg_uid(){
            return EventClass.data_msg_uid;
        };
        public static long data_from_user_id(){
            return EventClass.data_from_user_id;
        };
        public static int data_villa_id(){
            return EventClass.data_villa_id;
        };
        public static String data_text(){
            return EventClass.data_text;
        };
        public static String data_name(){
            return EventClass.data_name;
        };
        public static String data_name_id(){
            return EventClass.data_name_id;
        };
    }
}
