package com.sdk.hoyobot.entity.mys;


import lombok.Data;



@Data
public class Event {
//    robot	Robot	用户机器人访问凭证
//    type	int32	事件类型
//    id	string	事件 id
//    created_at	int64	事件创建时间的时间戳
//    send_at	int64	事件回调时间的时间戳
//    extend_data	ExtendData	扩展数据，保存事件的具体信息

    private Robot robot;
    private Integer type;
    private String id;
    private Long create_at;
    private Long send_at;
    private ExtendData extend_data;

}
