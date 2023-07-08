package com.sdk.botjavasdk.components;

import com.alibaba.fastjson.JSONObject;
import com.sdk.botjavasdk.entity.Event;
import lombok.Data;
import org.springframework.stereotype.Component;
//机器人
@Component
public class Bot {
    private static String bot_id=""; //机器人id
    private static String bot_secret=""; //机器人secret

    public static class Bots{
        public static String getBot_id() {return bot_id;}
        public static String getBot_secret() {
            return bot_secret;
        }
        public static void init(Event params){
            EventClass.Main.main(params.getEvent());
        }
        public static String text(){
            return EventClass.Main.data_text();
        }
        public static JSONObject callback(){
            JSONObject callbacked=new JSONObject();
            callbacked.put("message","请求成功");
            callbacked.put("retcode",0);
            return callbacked;
        }
    }
}
