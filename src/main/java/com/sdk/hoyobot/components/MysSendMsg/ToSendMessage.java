package com.sdk.hoyobot.components.MysSendMsg;

import com.alibaba.fastjson.JSONObject;
import com.sdk.hoyobot.Bot;
//import com.sdk.hoyobot.entity.AnalysisMessage;
import com.sdk.hoyobot.components.CallBack;
import com.sdk.hoyobot.components.MysSendMsg.MsgContent;
import com.sdk.hoyobot.entity.mys.SendMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class ToSendMessage {
    @Autowired
    MsgContent msgContent;
    @Autowired
    Bot Bot;

    //图片转存
    public String ZCImage(String imageurl, SendMessage sendMessage) {
        try {
            JSONObject js = new JSONObject();
            js.put("url", imageurl);
            RestTemplate restTemplate = new RestTemplate();
            String url = "https://bbs-api.miyoushe.com/vila/api/bot/platform/transferImage";
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.add("x-rpc-bot_id", Bot.getBot_id());
            headers.add("x-rpc-bot_secret", Bot.getBot_secret());
            headers.add("x-rpc-bot_villa_id", sendMessage.getVilla_id());
            HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(js, headers);
            ResponseEntity<JSONObject> responseEntity = restTemplate.postForEntity(url, requestEntity, JSONObject.class);
            JSONObject responseBody = responseEntity.getBody();
            if (responseBody.getInteger("retcode") == 10322003) {
                return "error";
            } else {
                if (responseBody.getJSONObject("data") == null || responseBody.getJSONObject("data").getString("new_url") == null) {
                    return "error";
                } else {
                    String ac = responseBody.getJSONObject("data").getString("new_url");
                    return ac;
                }

            }
        } catch (Exception e) {
            return "error";
        }

    }

    //发送图片类型
    public JSONObject SendImage(String imageurl, SendMessage sendMessage) {
        try {
            String answer = msgContent.msgcontentImage(imageurl);
            JSONObject js = new JSONObject();
            js.put("msg_content", answer);
            js.put("room_id", sendMessage.getRoom_id());
            js.put("object_name", "MHY:Image");
            RestTemplate restTemplate = new RestTemplate();
            //请求地址
            String url = "https://bbs-api.miyoushe.com/vila/api/bot/platform/sendMessage";
            //请求头类信息
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.add("x-rpc-bot_id", Bot.getBot_id());
            headers.add("x-rpc-bot_secret", Bot.getBot_secret());
            headers.add("x-rpc-bot_villa_id", sendMessage.getVilla_id());
            HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(js, headers);
            ResponseEntity<JSONObject> responseEntity = restTemplate.postForEntity(url, requestEntity, JSONObject.class);
            JSONObject responseBody = responseEntity.getBody();
            System.out.println("发送成功");
            return responseBody;

        } catch (Exception e) {
            return CallBack.callback();
        }
    }

    //前缀判断(无视大小写)
    public Boolean prefixwushi(String text, String prefix) {
        return text.toLowerCase().startsWith(prefix);
    }

    //前缀判断（不无视大小写）
    public Boolean prefix(String text, String prefix) {
        return text.toLowerCase().startsWith(prefix);
    }

    //判断text里是否存在具体内容
    public Boolean indexof(String text, String content) {
        if (text.indexOf(content) != -1) {
            return true;
        } else {
            return false;
        }
    }

    //发送消息文本类型
    public JSONObject SendText(String text, SendMessage sendMessage) {
        String answer = msgContent.msgcontentText(text);
        JSONObject js = new JSONObject();
        js.put("msg_content", answer);
        js.put("room_id", sendMessage.getRoom_id());
        js.put("object_name", "MHY:Text");
        RestTemplate restTemplate = new RestTemplate();
        //请求地址
        String url = "https://bbs-api.miyoushe.com/vila/api/bot/platform/sendMessage";
        //请求头类信息
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("x-rpc-bot_id", Bot.getBot_id());
        headers.add("x-rpc-bot_secret", Bot.getBot_secret());
        headers.add("x-rpc-bot_villa_id", sendMessage.getVilla_id());
        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(js, headers);
        ResponseEntity<JSONObject> responseEntity = restTemplate.postForEntity(url, requestEntity, JSONObject.class);
        JSONObject responseBody = responseEntity.getBody();
        return responseBody;

    }

    //回复集成(回复消息加发送消息)
    public JSONObject SendTextHuiFu(String text, SendMessage sendMessage) {
        String answer = msgContent.msgcontentTextHuiFu(text, sendMessage);
        JSONObject js = new JSONObject();
        js.put("msg_content", answer);
        js.put("room_id", sendMessage.getRoom_id());
        js.put("object_name", "MHY:Text");
        RestTemplate restTemplate = new RestTemplate();
        //请求地址
        String url = "https://bbs-api.miyoushe.com/vila/api/bot/platform/sendMessage";
        //请求头类信息
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("x-rpc-bot_id", Bot.getBot_id());
        headers.add("x-rpc-bot_secret", Bot.getBot_secret());
        headers.add("x-rpc-bot_villa_id", sendMessage.getVilla_id());
        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(js, headers);
        ResponseEntity<JSONObject> responseEntity = restTemplate.postForEntity(url, requestEntity, JSONObject.class);
        JSONObject responseBody = responseEntity.getBody();
        return responseBody;
    }

    //发送卡片集成一下
    public JSONObject SendTextCard(SendMessage sendMessage, String text, String icon_url, String image_url, String title, String content, String url, String source_name) {
        String answer = msgContent.msgcontentTextCard(text, icon_url, image_url, title, content, url, source_name);
        JSONObject js = new JSONObject();
        js.put("msg_content", answer);
        js.put("room_id", sendMessage.getRoom_id());
        js.put("object_name", "MHY:Text");
        RestTemplate restTemplate = new RestTemplate();
        //请求地址
        String urls = "https://bbs-api.miyoushe.com/vila/api/bot/platform/sendMessage";
        //请求头类信息
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("x-rpc-bot_id", Bot.getBot_id());
        headers.add("x-rpc-bot_secret", Bot.getBot_secret());
        headers.add("x-rpc-bot_villa_id", sendMessage.getVilla_id());
        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(js, headers);
        ResponseEntity<JSONObject> responseEntity = restTemplate.postForEntity(urls, requestEntity, JSONObject.class);
        JSONObject responseBody = responseEntity.getBody();
        return responseBody;
    }

    //发送徽标集成
    public JSONObject SendTextBadge(SendMessage sendMessage, String text, String icon_url, String url, String totext) {
        String answer = msgContent.msgcontentTextbadge(text, icon_url, url, totext);
        JSONObject js = new JSONObject();
        js.put("msg_content", answer);
        js.put("room_id", sendMessage.getRoom_id());
        js.put("object_name", "MHY:Text");
        RestTemplate restTemplate = new RestTemplate();
        //请求地址
        String urls = "https://bbs-api.miyoushe.com/vila/api/bot/platform/sendMessage";
        //请求头类信息
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("x-rpc-bot_id", Bot.getBot_id());
        headers.add("x-rpc-bot_secret", Bot.getBot_secret());
        headers.add("x-rpc-bot_villa_id", sendMessage.getVilla_id());
        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(js, headers);
        ResponseEntity<JSONObject> responseEntity = restTemplate.postForEntity(urls, requestEntity, JSONObject.class);
        JSONObject responseBody = responseEntity.getBody();
        return responseBody;
    }
}
