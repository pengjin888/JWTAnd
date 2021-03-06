package com.utils;

import java.util.Properties;

/**
 * @Version 1.0
 * @Author:penguins Shaw
 * @Date: 2021 03 2021-03-22 0:54
 * Description: No Description
 */

public class PropertiesUtils {
    //TEST1.mysql.database
    public static final String COMMON = "TEST1.mysql.database";
    public static final Properties properties = new Properties();

    public String getString(String key){
        return properties.getProperty(key);
    }

    public Integer getInteger(String key){
        try {
            return Integer.parseInt(properties.getProperty(key));
        }catch (Exception e){
            return null;
        }
    }
    public Long getLong(String key){
        try {
            return Long.parseLong(properties.getProperty(key));
        }catch (Exception e){
            return null;
        }
    }

    public Boolean getBoolean(String key){
        try {
            return Boolean.parseBoolean(properties.getProperty(key));
        }catch (Exception e){
            return null;
        }
    }
}