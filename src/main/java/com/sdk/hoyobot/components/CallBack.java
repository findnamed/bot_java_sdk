package com.sdk.hoyobot.components;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class CallBack {
    public static JSONObject callback(){JSONObject js=new JSONObject();js.put("message","");js.put("retcode",0);return js;}
}
