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

# controller->HelloController
