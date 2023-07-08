package com.sdk.botjavasdk.controller;

import com.alibaba.fastjson.JSONObject;
import com.sdk.botjavasdk.components.*;
import com.sdk.botjavasdk.entity.Event;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BotController {


    @PostMapping("/api1")
    public JSONObject apitest(@RequestBody Event params){
        //解析请求
        EventClass.Main.main(params.getEvent());
        String contented1=EventClass.Main.data_text();//原先变量
        String contented=contented1.replace(" ","");
        if(contented.indexOf("@摸鱼/拼大小") != -1){
            SendMessageText.pingdaxiao1();
        }else if(contented.indexOf("@摸鱼/复读") != -1){
            contented1=contented.replace("@摸鱼/复读","");
            if(contented.indexOf("色色") != -1){
                SendMessageText.delse();
            }else{
                SendMessageText.fudu1(contented1);
            }
        }else if(contented.indexOf("@摸鱼/对话") != -1){
            contented1=contented.replace("@摸鱼/对话","");
            SendMessageText.duihua1(contented1);
        }else if(contented.indexOf("@摸鱼图片测试") != -1){
            SendMessageText.upimages();
        }else if(contented.indexOf("色色")!=-1){
            SendMessageText.delse();
        }else if(contented.indexOf("@摸鱼帖子")!=-1){
            contented1=contented.replace("@摸鱼帖子","");
            contented1=contented1.replace(" ","");
            SendMessageText.posted(contented1);
        }else if(contented.indexOf("@摸鱼图片") != -1){
            contented1=contented.replace("@摸鱼图片","");
            contented1=contented1.replace(" ","");
            System.out.println(contented1);
            SendMessageText.upimages1(contented1);
        }else if(contented.indexOf("色图") != -1){
            SendMessageText.upimages2();
        }else if(contented.indexOf("回复")!=-1){
            SendMessageText.huifu();
        }else if(contented.indexOf("房间入侵")!=-1){
            SendMessageText.room_go();
        }else if(contented.indexOf("help")!=-1){
            SendMessageText.help();
        }
        else{
            contented1=contented.replace("@摸鱼","");
            contented1=contented1.replace(" ","");
            SendMessageText.elsetext();
        }
        JSONObject callbackdata=new JSONObject();
        callbackdata.put("message","请求成功");
        callbackdata.put("retcode",0);
        return callbackdata;
    }
    //单纯获取数据
    @RequestMapping("/api2")
    public JSONObject demo(@RequestBody JSONObject params){
        System.out.println(params);
        JSONObject callbackdata=new JSONObject();
        callbackdata.put("message","请求成功");
        callbackdata.put("retcode",0);
        return callbackdata;
    }
}





