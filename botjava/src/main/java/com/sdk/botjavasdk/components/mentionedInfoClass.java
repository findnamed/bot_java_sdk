package com.sdk.botjavasdk.components;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class mentionedInfoClass {
    //提及全员
    public static JSONObject mentionedInfoAll() {
        JSONObject param=new JSONObject();
        param.put("type",1);
        return param;

    }
    //需要提及的人员 1为所有 2为部分
    public static JSONObject mentionedInfo(int type, ArrayList<String> userIdList) {
        JSONObject param=new JSONObject();
        param.put("type",type);
        param.put("userIdList",userIdList);
        return param;
    }
}
