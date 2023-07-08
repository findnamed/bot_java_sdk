package com.sdk.botjavasdk.components;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class QuoteInfo {
    public static JSONObject quteinfo(String quoted_message_id,String quoted_message_send_time){
        long quoted_message_send_time1=Long.parseLong(quoted_message_send_time);
        JSONObject qute=new JSONObject();
        qute.put("original_message_id",quoted_message_id);
        qute.put("quoted_message_id",quoted_message_id);
        qute.put("original_message_send_time",quoted_message_send_time1);
        qute.put("quoted_message_send_time",quoted_message_send_time1);
        return qute;
    }
}
