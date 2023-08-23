package com.sdk.hoyobot.server;

import com.alibaba.fastjson.JSONObject;
import com.sdk.hoyobot.entity.mys.SendMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MsgText {

    @Value("${mys.name}")
    private String botname;

    //完整内容
    public String AnalysisContent(SendMessage sendMessage){
        return JSONObject.parseObject(sendMessage.getContent()).getJSONObject("content").getString("text").trim();
    }

    //去除@...后的内容
    public String AnalysisCntNoAt(SendMessage sendMessage){
        String content=JSONObject.parseObject(sendMessage.getContent()).getJSONObject("content").getString("text").trim();
        return content.replace("@"+botname,"").trim();
    }

    //去除@...后再去除开头的/
    public String AnalysisCntNoAtNoG(SendMessage sendMessage){
        String content=JSONObject.parseObject(sendMessage.getContent()).getJSONObject("content").getString("text").trim();
        content=content.replace("@"+botname,"").trim();
        if(content.charAt(0)=='/'){
            return content.substring(1);
        }else{
            return content;
        }
    }
}
