package com.sdk.botjavasdk.components;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;
//集成过后的发送
@Component
public class SendMessageClass {
    //置顶消息(消息是否取消置顶)
    public static void pinMessage(Boolean is_cancel){

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("x-rpc-bot_id", Bot.Bots.getBot_id());
        headers.add("x-rpc-bot_secret",Bot.Bots.getBot_secret());
        headers.add("x-rpc-bot_villa_id", String.valueOf(EventClass.Main.data_villa_id()));
        String url = "https://bbs-api.miyoushe.com/vila/api/bot/platform/pinMessage";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("msg_uid",EventClass.Main.data_msg_uid() )
                .queryParam("is_cancel",is_cancel )
                .queryParam("room_id",EventClass.Main.data_room_id() )
                .queryParam("send_at",EventClass.Main.send_at());

        HttpEntity<?> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<JSONObject> responseEntity = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, requestEntity, JSONObject.class);
        JSONObject responseBody = responseEntity.getBody();
    }

    //撤回消息
    public static void recallMessage(){

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("x-rpc-bot_id", Bot.Bots.getBot_id());
        headers.add("x-rpc-bot_secret",Bot.Bots.getBot_secret());
        headers.add("x-rpc-bot_villa_id", String.valueOf(EventClass.Main.data_villa_id()));
        String url = "https://bbs-api.miyoushe.com/vila/api/bot/platform/recallMessage";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("msg_uid",EventClass.Main.data_msg_uid() )
                .queryParam("room_id",EventClass.Main.data_room_id() )
                .queryParam("msg_time",EventClass.Main.data_send_at());

        HttpEntity<?> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<JSONObject> responseEntity = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, requestEntity, JSONObject.class);
        JSONObject responseBody = responseEntity.getBody();
    }


    //发送消息文本类型
    public static JSONObject SendText(String text){
        String answer=MsgContent.msgcontentText(text);
        JSONObject js=new JSONObject();
        js.put("msg_content",answer);
        js.put("room_id",EventClass.Main.data_room_id());
        js.put("object_name","MHY:Text");
        RestTemplate restTemplate = new RestTemplate();
        //请求地址
        String url="https://bbs-api.miyoushe.com/vila/api/bot/platform/sendMessage";
        //请求头类信息
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("x-rpc-bot_id",Bot.Bots.getBot_id());
        headers.add("x-rpc-bot_secret",Bot.Bots.getBot_secret());
        headers.add("x-rpc-bot_villa_id",String.valueOf(EventClass.Main.data_villa_id()));
        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(js, headers);
        ResponseEntity<JSONObject> responseEntity = restTemplate.postForEntity(url, requestEntity, JSONObject.class);
        JSONObject responseBody = responseEntity.getBody();
        return responseBody;
    }

    //发送图片类型
    public static JSONObject SendImage(String imageurl){
        String answer=MsgContent.msgcontentImage(imageurl);
        JSONObject js=new JSONObject();
        js.put("msg_content",answer);
        js.put("room_id",EventClass.Main.data_room_id());
        js.put("object_name","MHY:Image");
        RestTemplate restTemplate = new RestTemplate();
        //请求地址
        String url="https://bbs-api.miyoushe.com/vila/api/bot/platform/sendMessage";
        //请求头类信息
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("x-rpc-bot_id",Bot.Bots.getBot_id());
        headers.add("x-rpc-bot_secret",Bot.Bots.getBot_secret());
        headers.add("x-rpc-bot_villa_id",String.valueOf(EventClass.Main.data_villa_id()));
        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(js, headers);
        ResponseEntity<JSONObject> responseEntity = restTemplate.postForEntity(url, requestEntity, JSONObject.class);
        JSONObject responseBody = responseEntity.getBody();
        System.out.println("发送成功");
        return responseBody;
    }

    //发送帖子
    public static JSONObject SendPost(String postid){
        String answer=MsgContent.msgcontentPost(postid);
        JSONObject js=new JSONObject();
        js.put("villa_id",EventClass.Main.data_villa_id());
        js.put("room_id",EventClass.Main.data_room_id());
        js.put("object_name","MHY:Post");
        js.put("msg_content",answer);
        RestTemplate restTemplate = new RestTemplate();
        //请求地址
        String url="https://bbs-api.miyoushe.com/vila/api/bot/platform/sendMessage";
        //请求头类信息
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("x-rpc-bot_id",Bot.Bots.getBot_id());
        headers.add("x-rpc-bot_secret",Bot.Bots.getBot_secret());
        headers.add("x-rpc-bot_villa_id",String.valueOf(EventClass.Main.data_villa_id()));
        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(js, headers);
        ResponseEntity<JSONObject> responseEntity = restTemplate.postForEntity(url, requestEntity, JSONObject.class);
        JSONObject responseBody = responseEntity.getBody();
        System.out.println("发送成功");
        return responseBody;
    }

}
