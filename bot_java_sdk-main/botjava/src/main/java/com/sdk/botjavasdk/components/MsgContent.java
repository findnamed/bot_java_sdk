package com.sdk.botjavasdk.components;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class MsgContent {
    //生成字符串(有@的,有回复的)
    public static String msgcontentAtHuifu(String text, ArrayList<JSONObject> entities, JSONObject mentionedInfo, JSONObject quote) {
        JSONObject js=new JSONObject();
        js.put("text",text);
        js.put("entities",entities);
        js.put("mentionedInfo",mentionedInfo);
        js.put("quote",quote);
        JSONObject js2=new JSONObject();
        js2.put("content",js);
        String answer=js2.toJSONString();
        return answer;
    }
    //有@无回复的
    public static String msgcontentAt(String text, ArrayList<JSONObject> entities, JSONObject mentionedInfo) {
        JSONObject js=new JSONObject();
        js.put("text",text);
        js.put("entities",entities);
        js.put("mentionedInfo",mentionedInfo);
        JSONObject js2=new JSONObject();
        js2.put("content",js);
        String answer=js2.toJSONString();
        return answer;
    }

    //无@有回复
    public static String msgcontentHuifu(String text, ArrayList<JSONObject> entities, JSONObject quote) {
        JSONObject js=new JSONObject();
        js.put("text",text);
        js.put("entities",entities);
        js.put("quote",quote);
        JSONObject js2=new JSONObject();
        js2.put("content",js);
        String answer=js2.toJSONString();
        return answer;
    }
    //无@无回复
    public static String msgcontent(String text, ArrayList<JSONObject> entities) {
        JSONObject js=new JSONObject();
        js.put("text",text);
        js.put("entities",entities);
        JSONObject js2=new JSONObject();
        js2.put("content",js);
        String answer=js2.toJSONString();
        return answer;
    }
    //纯文本发送
    public static String msgcontentText(String text){
        ArrayList<JSONObject> array=new ArrayList<>();
        JSONObject js=new JSONObject();
        js.put("text",text);
        js.put("entities",array);
        JSONObject js2=new JSONObject();
        js2.put("content",js);
        String answer=js2.toJSONString();
        return answer;
    }


    //图片
    public static String msgcontentImage(String url){
        JSONObject js=new JSONObject();
        js.put("url",url);
        JSONObject js2=new JSONObject();
        js2.put("content",js);
        String answer=js2.toJSONString();
        return answer;
    }

    //帖子
    public static String msgcontentPost(String id){
        JSONObject js=new JSONObject();
        js.put("post_id",id);
        JSONObject js2=new JSONObject();
        js2.put("content",js);
        String answer=js2.toJSONString();
        return answer;
    }
}
