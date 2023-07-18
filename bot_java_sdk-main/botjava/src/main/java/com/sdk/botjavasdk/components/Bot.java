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
    private static String pub_key="";//机器人的pub_key

    private static String bot_secret1=Cipher.hmacSha256(pub_key,bot_secret);//加密后的secret
    public static class Bots{
        public static String getBot_id() {return bot_id;}
        public static String getBot_secret() {return bot_secret1;}
        //未加密的secret
        public static String getBot_secretyuan(){return bot_secret;}
        public static String getBot_pub_key(){return pub_key;}
        public static void init(JSONObject params){
            Event param = JSONObject.parseObject(params.toJSONString(), Event.class);
            EventClass.Main.main(param.getEvent());
        }
        //签名校验
        public static Boolean verification(String sign,JSONObject params)throws Exception{
            return VerificationHelper.verify(sign,params.toJSONString(),bot_secret,pub_key);
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
