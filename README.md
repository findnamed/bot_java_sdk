# bot_java_sdk
mhy大别野java版sdk，第一次做应该算模板吧

# components->Bot配置bot_id和bot_secret
```java

#  resources->application.yml配置端口
```java
server:
  port: 填自己的端口
spring:
  mvc:
    static-path-pattern: /**
  main:
    allow-circular-references: true
mys:
  id: 填自己的机器人ID
  secret: 填自己的机器人令牌
  pubKey: 填自己的机器人公钥
  name: 填自己的机器人名字

```
# components->TestController配置接口
```java
package com.sdk.hoyobot.controller;

import com.alibaba.fastjson.JSONObject;
import com.sdk.hoyobot.Bot;
import com.sdk.hoyobot.components.CallBack;
import com.sdk.hoyobot.components.MysSendMsg.ToSendMessage;
import com.sdk.hoyobot.components.VerificationHelper;
import com.sdk.hoyobot.entity.mys.SendMessage;
import com.sdk.hoyobot.server.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {

    @Autowired
    ReplyService replyService;
    @Autowired
    ToSendMessage toSendMessage;
    @Autowired
    Bot Bot;
    
    @RequestMapping("自己配置接口")
    public JSONObject testtoarp(@RequestHeader("x-rpc-bot_sign") String sign, @RequestBody JSONObject params) {
        try {
            if (!VerificationHelper.verify(sign, params.toJSONString(),Bot.getBot_secretyuan(),Bot.getBot_pub_key())) {
                return CallBack.callback();
            }
            JSONObject repsObject = params.getJSONObject("event");
            Integer type = (Integer) repsObject.get("type");
            switch (type) {
                case 1:
                    break;
                case 2:
                    SendMessage sendMessage = JSONObject.parseObject(repsObject.getJSONObject("extend_data").getJSONObject("EventData").getString("SendMessage"), SendMessage.class);
                    replyService.replyMys(sendMessage);
                    break;
                case 3:

                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return CallBack.callback();
    }
}

//所有指令可在这里处理
# components->CMD
package com.sdk.hoyobot.components;

import com.sdk.hoyobot.components.MysSendMsg.ToSendMessage;
import com.sdk.hoyobot.entity.mys.SendMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CMD {

    @Autowired
    ToSendMessage toSendMessage;

    public void excute(SendMessage sendMessage,String text){
        try {
            switch (text){
                case "hello":
                    toSendMessage.SendTextHuiFu("你好",sendMessage);
                    return;
                default:
                    toSendMessage.SendTextHuiFu("未知的指令",sendMessage);
                    return;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
配置完后，启动后，在自己的房间中 @机器人 hello 机器人会返回给你world表示你可以使用了
```
