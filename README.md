# 建议查看new分支[new分支已更新]
# bot_java_sdk
mhy大别野java版sdk，第一次做应该算模板吧

# components->Bot配置bot_id和bot_secret
```java

//机器人
@Component
public class Bot {
    private static String bot_id=""; //机器人id
    private static String bot_secret=""; //机器人secret
```
#  resources->application.properties配置端口
```java
server.port= 填自己申请的端口号
```

# controller->HelloController配置接口
```java
package com.sdk.botjavasdk.controller;

import com.alibaba.fastjson.JSONObject;
import com.sdk.botjavasdk.components.*;
import com.sdk.botjavasdk.entity.Event;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HelloController {
    //填自己的接口
    @PostMapping("/自己的接口")
    //测试样例@机器人 输入 hello 返回 world
    public JSONObject hello(@RequestBody Event params){
        Bot.Bots.init(params);//解析回调
        String data_text=Bot.Bots.text();//读取用户发送的文本消息
        System.out.println(data_text);
        if(data_text.indexOf("hello")!=-1){ //若包含hello
            SendMessageClass.SendText("world");//返回world
        }
        return Bot.Bots.callback();//返回参数
    }
}

```
配置完后，启动后，在自己的房间中 @机器人 hello 机器人会返回给你world表示你可以使用了
