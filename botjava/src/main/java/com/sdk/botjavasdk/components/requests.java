package com.sdk.botjavasdk.components;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.util.Map;

@Component
public class requests {
    //另一个chatgpt接口
    public static String chat( String texts){
        //构建参数
        JSONObject params=new JSONObject();
        JSONObject empty=new JSONObject();
        params.put("options",empty);
        params.put("userId","#/chat/1688351538146");
        params.put("usingContext",true);
        params.put("prompt",texts);
        //创建请求对象
        RestTemplate restTemplate = new RestTemplate();
        //请求地址
        String url="https://chat-api.wuguokai.cn/api/chat-process";
        //请求头类信息
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Origin","https://ai.wuguokai.cn");
        headers.add("Referer","https://ai.wuguokai.cn/");

        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(params, headers);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, requestEntity, String.class);
        String responseBody = responseEntity.getBody();
        byte[] bytes = new byte[0];
        try {
            bytes = responseBody.getBytes("ISO8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            responseBody = new String(bytes,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        responseBody=responseBody.replace("ChatGPT","AI");
        responseBody=responseBody.replace("GPT","AI");
        responseBody=responseBody.replace("wuguikai","AI");
        return responseBody;
    }
}
