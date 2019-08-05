package com.yanchun.utils;

import java.util.UUID;

/**
 * ID工具类
 */
public class IdUtils {

    /**
     * 生成UUID
     * @return
     */
    public static String getUUID(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
