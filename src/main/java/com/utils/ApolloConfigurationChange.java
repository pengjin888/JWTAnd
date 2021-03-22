//package com.utils;
//
//import com.ctrip.framework.apollo.Config;
//import com.ctrip.framework.apollo.model.ConfigChange;
//
//import java.util.Properties;
//import java.util.Set;
//
///**
// * @Version 1.0
// * @Author:penguins Shaw
// * @Date: 2021 03 2021-03-22 0:53
// * Description: No Description
// */
//public class ApolloConfigurationChange {
//    public static void monitorApolloConfigurationChange(Properties properties, Config config){
//        config.addChangeListener(configChangeEvent -> {
//            Set<String> keys = configChangeEvent.changedKeys();
//            for(String key : keys){
//                ConfigChange configChange = configChangeEvent.getChange(key);
//                //覆盖旧值
//                PropertiesUtils.properties.setProperty(key,configChange.getNewValue());
//                System.out.println(configChange.getPropertyName()+" 的值改变了，原值："+
//                        configChange.getOldValue()+",新值："+configChange.getNewValue());
//            }
//        });
//    }
//}