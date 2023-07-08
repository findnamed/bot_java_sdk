package com.sdk.botjavasdk.components;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

//获取大别野信息
@Component
public class GetVilla {
    //传参为大别野id
    public static JSONObject getvilla(){
        JSONObject params=new JSONObject();
        RestTemplate restTemplate = new RestTemplate();
        Integer villa_id=EventClass.Main.data_villa_id();
        //请求地址
        String url="https://bbs-api.miyoushe.com/vila/api/bot/platform/getVilla";
        //请求头类信息
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("x-rpc-bot_id",Bot.Bots.getBot_id());
        headers.add("x-rpc-bot_secret",Bot.Bots.getBot_secret());
        headers.add("x-rpc-bot_villa_id", String.valueOf(villa_id));

        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(params, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url,HttpMethod.GET,requestEntity, String.class);
        String responseBody = responseEntity.getBody();
        JSONObject villa_data= JSON.parseObject(responseBody);
        return villa_data;
    }
}
