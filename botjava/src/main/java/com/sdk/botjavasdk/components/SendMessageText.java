package com.sdk.botjavasdk.components;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

@Component
public class SendMessageText {
    //拼大小
    public static void pingdaxiao1(){
        int randomNumber = new Random().nextInt(6)+1;
        ArrayList<JSONObject> arrays=new ArrayList<>();
        String answer=MsgContent.msgcontent(String.valueOf(randomNumber),arrays);
        SendMessage.SendText(EventClass.Main.data_room_id(),answer);
    }
    //对话
    public static void duihua1(String params1){
            //消息中转
        String reponse=requests.chat(params1);
        ArrayList<JSONObject> arrays=new ArrayList<>();
        String answer=MsgContent.msgcontent(reponse,arrays);
        SendMessage.SendText(EventClass.Main.data_room_id(),answer);
    }
    //复读
    public static void fudu1(String params1){
            ArrayList<JSONObject> arrays=new ArrayList<>();
            String answer=MsgContent.msgcontent(params1,arrays);
            SendMessage.SendText(EventClass.Main.data_room_id(),answer);
    }

    //图片测试
    public static void upimages(){
        String answer=MsgContent.msgcontentImage("https://upload-bbs.miyoushe.com/upload/2023/07/07/261040620/de22b7d431ee23a0f8a8425d1f5c2a92_2514205574427881909.gif");
        SendMessage.SendImage(EventClass.Main.data_room_id(),answer);
    }

    //喜欢色色是吧
    public static void delse(){
        SendMessage.recallMessage(EventClass.Main.data_msg_uid(),EventClass.Main.data_room_id(),EventClass.Main.data_send_at());
        ArrayList<JSONObject> array=new ArrayList<>();
        String answer=MsgContent.msgcontent("别野并发法外之地，禁止色色",array);
        SendMessage.SendText(EventClass.Main.data_room_id(),answer);
    }
    //试试发送帖子
    public static void posted(String params){
        String answer=MsgContent.msgcontentPost(params);
        SendMessage.SendPost(EventClass.Main.data_room_id(),answer);
    }
    //图片测试(给个url)
    public static void upimages1(String url){
        String answer=MsgContent.msgcontentImage(url);
        SendMessage.SendImage(EventClass.Main.data_room_id(),answer);
    }

    //其他情况就蒙混过关吧
    public static void elsetext(){
        ArrayList<JSONObject> array=new ArrayList<>();
        String answer=MsgContent.msgcontent("若没其他事,本次服务将会在3次“嘟”字后结束，感谢您的访问......\n" + "\n" + "嘟——嘟——嘟——",array);
        SendMessage.SendText(EventClass.Main.data_room_id(),answer);
    }


    //测试回复接口
    public static void huifu(){
        ArrayList<JSONObject> array=new ArrayList<>();
        JSONObject quote=QuoteInfo.quteinfo(EventClass.Main.data_msg_uid(),EventClass.Main.data_send_at());
        String answer=MsgContent.msgcontentHuifu("我回复你了，然后你打算咋样",array,quote);
        SendMessage.SendText(EventClass.Main.data_room_id(),answer);
    }
    //图片发送接口测试
    public static void upimages2(){
        String answer=MsgContent.msgcontentImage("https://upload-bbs.miyoushe.com/upload/2023/06/24/261040620/29d389d960e834c61c1111116845f924_2289068632245495635.jpg");
        SendMessage.SendImage(EventClass.Main.data_room_id(),answer);
        SendMessageText.fudu1(EventClass.Main.data_nickname()+" 铐走，拷走,三年以上，最高死刑");
        SendMessageText.delse();
    }

    //房间入侵
    public static void room_go(){
        ArrayList<JSONObject> array=new ArrayList<>();
        JSONObject js=EntityClass.villa_room_link("2005","29996",1000,0);
        array.add(js);
//        System.out.println(array);
        String answer=MsgContent.msgcontent("房间入侵",array);
        SendMessage.SendText(EventClass.Main.data_room_id(),answer);
    }
    //房间帮助
    public static void help(){
         ArrayList<JSONObject> array=new ArrayList<>();
         String answer=MsgContent.msgcontent("所有指令都需要@机器人\n【以下为指令列表】 \n图片测试 \n色色 \n帖子【填入帖子ID】 \n图片【填入图片url】 \n色图 --不建议尝试 \n回复 --只是单纯的回复 \n房间入侵 --试试就知道了  \n",array);
         SendMessage.SendText(EventClass.Main.data_room_id(),answer);
    }
}
