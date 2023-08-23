package com.sdk.hoyobot;

import com.sdk.hoyobot.components.Cipher;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
@Getter
public class Bot {
    @Autowired
    Cipher cipher;

    @Value("${mys.id}")
    private String bot_id;

    @Value("${mys.secret}")
    private String bot_secret;
    @Value("${mys.pubKey}")
    private String pub_key;

    public String getBot_id() {return bot_id; }
    public String getBot_secret() {
        return cipher.hmacSha256(pub_key,bot_secret);
    }
    public String getBot_secretyuan() {
        return bot_secret;
    }
    public String getBot_pub_key() {
        return pub_key;
    }


}
