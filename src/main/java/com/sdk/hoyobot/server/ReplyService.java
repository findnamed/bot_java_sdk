package com.sdk.hoyobot.server;

import com.sdk.hoyobot.components.CMD;
import com.sdk.hoyobot.entity.mys.SendMessage;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class ReplyService {

    @Autowired
    MsgText msgText;
    @Autowired
    CMD cmd;
    public void replyMys(SendMessage sendMessage) {
        try {
            //自动去除了@符号
            String text= msgText.AnalysisCntNoAt(sendMessage);
            cmd.excute(sendMessage,text);

            
        }catch (Exception e){
            System.out.println("执行出错");
            e.printStackTrace();
        }
        }
}
