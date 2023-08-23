package com.sdk.hoyobot.components.MysSendMsg;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;
import com.sdk.hoyobot.entity.mys.SendMessage;

import java.util.ArrayList;

@Component
public class MsgContent {
    //生成字符串(有@的,有回复的)
    public String msgcontentAtHuifu(String text, ArrayList<JSONObject> entities, JSONObject mentionedInfo, JSONObject quote) {
        JSONObject js = new JSONObject();
        js.put("text", text);
        js.put("entities", entities);
        js.put("mentionedInfo", mentionedInfo);
        js.put("quote", quote);
        JSONObject js2 = new JSONObject();
        js2.put("content", js);
        String answer = js2.toJSONString();
        return answer;
    }

    //有@无回复的
    public String msgcontentAt(String text, ArrayList<JSONObject> entities, JSONObject mentionedInfo) {
        JSONObject js = new JSONObject();
        js.put("text", text);
        js.put("entities", entities);
        js.put("mentionedInfo", mentionedInfo);
        JSONObject js2 = new JSONObject();
        js2.put("content", js);
        String answer = js2.toJSONString();
        return answer;
    }

    //无@有回复
    public String msgcontentHuifu(String text, ArrayList<JSONObject> entities, JSONObject quote) {
        JSONObject js = new JSONObject();
        js.put("text", text);
        js.put("entities", entities);
        js.put("quote", quote);
        JSONObject js2 = new JSONObject();
        js2.put("content", js);
        String answer = js2.toJSONString();
        return answer;
    }

    //无@无回复
    public String msgcontent(String text, ArrayList<JSONObject> entities) {
        JSONObject js = new JSONObject();
        js.put("text", text);
        js.put("entities", entities);
        JSONObject js2 = new JSONObject();
        js2.put("content", js);
        String answer = js2.toJSONString();
        return answer;
    }

    //纯文本发送
    public String msgcontentText(String text) {
        ArrayList<JSONObject> array = new ArrayList<>();
        JSONObject js = new JSONObject();
        js.put("text", text);
        js.put("entities", array);
        JSONObject js2 = new JSONObject();
        js2.put("content", js);
        String answer = js2.toJSONString();
        return answer;
    }

    //纯文本发送(附加回复)
    public String msgcontentTextHuiFu(String text, SendMessage sendMessage) {
        ArrayList<JSONObject> array = new ArrayList<>();
        JSONObject js = new JSONObject();
        JSONObject hf = new JSONObject();
        hf.put("quoted_message_send_time", Long.valueOf(sendMessage.getSend_at()));
        hf.put("original_message_id", sendMessage.getMsg_uid());
        hf.put("original_message_send_time", Long.valueOf(sendMessage.getSend_at()));
        hf.put("quoted_message_id", sendMessage.getMsg_uid());
        js.put("quote", hf);
        js.put("text", text);
        js.put("entities", array);
        JSONObject js2 = new JSONObject();
        js2.put("content", js);
        String answer = js2.toJSONString();
        return answer;
    }

    //发送卡片
    public String msgcontentTextCard(String text, String icon_url, String image_url, String title, String content, String url, String source_name) {
        ArrayList<JSONObject> array = new ArrayList<>();
        JSONObject js = new JSONObject();
        JSONObject hf = new JSONObject();
        JSONObject card = new JSONObject();
        card.put("icon_url", icon_url);
        card.put("image_url", image_url);
        card.put("is_internal_link", true);
        card.put("title", title);
        card.put("content", content);
        card.put("url", url);
        card.put("source_name", source_name);
        js.put("preview_link", card);
        js.put("text", text);
        js.put("entities", array);
        JSONObject js2 = new JSONObject();
        js2.put("content", js);
        String answer = js2.toJSONString();
        return answer;
    }

    //发送徽标
    public static String msgcontentTextbadge(String text, String icon_url, String url, String totext) {
        ArrayList<JSONObject> array = new ArrayList<>();
        JSONObject js = new JSONObject();
        JSONObject badge = new JSONObject();
        badge.put("icon_url", icon_url);
        badge.put("text", totext);
        badge.put("url", url);
        js.put("badge", badge);
        js.put("text", text);
        js.put("entities", array);
        JSONObject js2 = new JSONObject();
        js2.put("content", js);
        String answer = js2.toJSONString();
        return answer;
    }

    //图片
    public String msgcontentImage(String url) {
        JSONObject js = new JSONObject();
        js.put("url", url);
        JSONObject js2 = new JSONObject();
        js2.put("content", js);
        String answer = js2.toJSONString();
        return answer;
    }

    //帖子
    public String msgcontentPost(String id) {
        JSONObject js = new JSONObject();
        js.put("post_id", id);
        JSONObject js2 = new JSONObject();
        js2.put("content", js);
        String answer = js2.toJSONString();
        return answer;
    }
}
