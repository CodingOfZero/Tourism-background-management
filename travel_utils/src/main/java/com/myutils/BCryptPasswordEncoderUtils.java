package com.myutils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 加密字符串
 */
public class BCryptPasswordEncoderUtils {
    private static BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
    public static String encodePassword(String password){
        return bCryptPasswordEncoder.encode((password));
    }

    public static void main(String[] args) {
        String a="456";
        System.out.println(BCryptPasswordEncoderUtils.encodePassword(a));
    }
}
