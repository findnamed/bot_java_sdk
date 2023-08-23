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

    @RequestMapping("/api")
    public JSONObject testtoarp(@RequestHeader("x-rpc-bot_sign") String sign, @RequestBody JSONObject params) {
        try {
            //签名校验
            if (!VerificationHelper.verify(sign, params.toJSONString(),Bot.getBot_secretyuan(),Bot.getBot_pub_key())) {
                //签名校验失败的返回也可以自己写
                return CallBack.callback();
            }
            JSONObject repsObject = params.getJSONObject("event");
            //获取类型
            Integer type = (Integer) repsObject.get("type");

//        JoinVilla	有新用户加入大别野	1
//        SendMessage	用户@机器人发送消息	2
//        CreateRobot	大别野添加机器人实例	3
//        DeleteRobot	大别野删除机器人实例	4
//        AddQuickEmoticon	用户使用表情回复消息表态	5
//        AuditCallback	审核结果回调	6
            switch (type) {
                case 1:
                    //有新用户加入大别野
                    //todo  迎新回复
                    break;
                case 2:
                    //用户@机器人发送消息 指令匹配
                    SendMessage sendMessage = JSONObject.parseObject(repsObject.getJSONObject("extend_data").getJSONObject("EventData").getString("SendMessage"), SendMessage.class);
                    replyService.replyMys(sendMessage);
                    break;
                case 3:
                    //大别野添加机器人实例	3
                    break;
                case 4:
                    //大别野删除机器人实例	4
                    break;
                case 5:
                    //用户使用表情回复消息表态	5
                    break;
                case 6:
                    //AuditCallback	审核结果回调	6
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
