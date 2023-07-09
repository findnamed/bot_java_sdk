package com.sdk.botjavasdk.components;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


//获取用户api
@Component
public class GetMember {
    //获取用户信息
    public static JSONObject getmember(String uid){
        Integer villa_id=EventClass.Main.data_villa_id();
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("x-rpc-bot_id", Bot.Bots.getBot_id());
        headers.add("x-rpc-bot_secret",Bot.Bots.getBot_secret());
        headers.add("x-rpc-bot_villa_id", String.valueOf(villa_id));
        String url = "https://bbs-api.miyoushe.com/vila/api/bot/platform/getMember";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("uid", uid);

        HttpEntity<?> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<JSONObject> responseEntity = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, requestEntity, JSONObject.class);
        JSONObject responseBody = responseEntity.getBody();
        return responseBody;
    }
    //获取用户列表
    public static JSONObject getmemberlist(){
        Integer villa_id=EventClass.Main.data_villa_id();
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("x-rpc-bot_id", Bot.Bots.getBot_id());
        headers.add("x-rpc-bot_secret",Bot.Bots.getBot_secret());
        headers.add("x-rpc-bot_villa_id", String.valueOf(villa_id));
        String url = "https://bbs-api.miyoushe.com/vila/api/bot/platform/getVillaMembers";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("size",1000 );

        HttpEntity<?> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<JSONObject> responseEntity = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, requestEntity, JSONObject.class);
        JSONObject responseBody = responseEntity.getBody();
        System.out.println(responseBody);
        return responseBody;
    }

    //用户踢出大别野(不建议使用)
    public static JSONObject deletemember(String uid){
        Integer villa_id=EventClass.Main.data_villa_id();
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("x-rpc-bot_id", Bot.Bots.getBot_id());
        headers.add("x-rpc-bot_secret",Bot.Bots.getBot_secret());
        headers.add("x-rpc-bot_villa_id", String.valueOf(villa_id));
        String url = "https://bbs-api.miyoushe.com/vila/api/bot/platform/deleteVillaMember";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("uid", uid);

        HttpEntity<?> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<JSONObject> responseEntity = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, requestEntity, JSONObject.class);
        JSONObject responseBody = responseEntity.getBody();
        return responseBody;
    }
}
