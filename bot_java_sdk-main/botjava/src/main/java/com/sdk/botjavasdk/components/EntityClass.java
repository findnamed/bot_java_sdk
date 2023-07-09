package com.sdk.botjavasdk.components;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class EntityClass {
    //@机器人(id),颜色长度，颜色起始点
    public static JSONObject mentioned_robot(String bot_id,int length,int offset){
        JSONObject params=new JSONObject();
        params.put("type","mentioned_robot");
        params.put("bot_id",bot_id);
        JSONObject params1=new JSONObject();
        params1.put("entity",params1);
        params1.put("length",length);
        params1.put("offset",offset);
        return params1;
    }
    //@用户
    public static JSONObject mentioned_user(String user_id,int length,int offset){
        JSONObject params=new JSONObject();
        params.put("type","mentioned_user");
        params.put("user_id",user_id);
        JSONObject params1=new JSONObject();
        params1.put("entity",params1);
        params1.put("length",length);
        params1.put("offset",offset);
        return params1;
    }
    //@全体成员
    public static JSONObject mentioned_all(int length,int offset){
        JSONObject params=new JSONObject();
        params.put("type","mentioned_all");
        JSONObject params1=new JSONObject();
        params1.put("entity",params1);
        params1.put("length",length);
        params1.put("offset",offset);
        return params1;
    }

    //@跳转大别野内的房间
    public static JSONObject villa_room_link(String villa_id,String room_id,int length,int offset){
        JSONObject params=new JSONObject();
        params.put("type","villa_room_link");
        params.put("villa_id",villa_id);
        params.put("room_id",room_id);
        JSONObject params1=new JSONObject();
        params1.put("entity",params);
        params1.put("length",length);
        params1.put("offset",offset);
        return params1;
    }
}
