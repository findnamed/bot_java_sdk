package com.sdk.hoyobot.components;

import com.sdk.hoyobot.components.MysSendMsg.ToSendMessage;
import com.sdk.hoyobot.entity.mys.SendMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
//所有指令可在这里处理
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
