package com.yanchun.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Author quyanchun
 * @Date 2019/8/31
 */
public class test {
    public static void main(String[] args) {
        String encode = new BCryptPasswordEncoder().encode("admin");
        System.out.println(encode);
    }
}
