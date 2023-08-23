package com.sdk.hoyobot.components;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
//签名校验
public class VerificationHelper {

    public static boolean verify(String sign, String body, String secret, String pubKey) throws Exception {
        //公钥
        pubKey = pubKey
                .replace("-----BEGIN PUBLIC KEY-----", "")
                .replace("-----END PUBLIC KEY-----", "")
                .replaceAll("\\s+", "");  // 去除空格和换行符

        byte[] signArg = Base64.getDecoder().decode(sign);
        String encodedBody = URLEncoder.encode(body, "UTF-8");
        String encodedSecret = URLEncoder.encode(secret, "UTF-8");
        String str = "body=" + encodedBody + "&secret=" + encodedSecret;
        // 解码公钥
        byte[] pubKeyBytes = Base64.getDecoder().decode(pubKey);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(pubKeyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(keySpec);
        // 使用 RSA 验证签名
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initVerify(publicKey);
        signature.update(str.getBytes(StandardCharsets.UTF_8));
        boolean isValid = signature.verify(signArg);

        return isValid;
    }

}