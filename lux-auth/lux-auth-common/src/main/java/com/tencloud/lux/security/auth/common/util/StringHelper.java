package com.tencloud.lux.security.auth.common.util;

public class StringHelper {
    public static String getObjectValue(Object obj){
        return obj==null?"":obj.toString();
    }
}
