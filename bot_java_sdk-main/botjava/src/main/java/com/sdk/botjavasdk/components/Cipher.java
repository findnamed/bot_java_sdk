package com.sdk.botjavasdk.components;

import org.springframework.stereotype.Component;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
//加密传输
@Component
public class Cipher {
    public static String hmacSha256(String pubKey, String botSecret) {
        try {
            String start="-----BEGIN PUBLIC KEY-----";
            String end="-----END PUBLIC KEY-----"+"\n";
            pubKey=pubKey.replace("-----BEGIN PUBLIC KEY-----","");
            pubKey=pubKey.replace("-----END PUBLIC KEY-----","");
            pubKey=pubKey.replace(" ","\n");
            pubKey=start+pubKey+end;
            SecretKeySpec signingKey = new SecretKeySpec(pubKey.getBytes("utf-8"), "HmacSHA256");
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(signingKey);
            byte[] rawHmac = mac.doFinal(botSecret.getBytes("utf-8"));
             return DatatypeConverter.printHexBinary(rawHmac).toLowerCase();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }




}
