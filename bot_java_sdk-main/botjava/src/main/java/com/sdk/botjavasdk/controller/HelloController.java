package com.sdk.botjavasdk.controller;

import com.alibaba.fastjson.JSONObject;
import com.sdk.botjavasdk.components.*;
import com.sdk.botjavasdk.entity.Event;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HelloController {
    //填自己的接口
    @PostMapping("/bot")
    //测试样例@机器人 输入 hello 返回 world
    public JSONObject hello(@RequestHeader("x-rpc-bot_sign")String sign, @RequestBody JSONObject params)throws Exception{
        Bot.Bots.init(params);//解析回调
        //签名验证
        if(!Bot.Bots.verification(sign,params)){//如果签名验证失败
            //方法可以自己写//
            return Bot.Bots.callback();//返回参数
        }
        String data_text=Bot.Bots.text();//读取用户发送的文本消息
        if(data_text.indexOf("hello")!=-1){ //若包含hello
            SendMessageClass.SendText("world");//返回world
        }
        return Bot.Bots.callback();//返回参数
    }
}
