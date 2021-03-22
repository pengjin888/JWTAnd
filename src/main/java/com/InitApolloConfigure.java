//package com;
//
///**
// * @Version 1.0
// * @Author:penguins Shaw
// * @Date: 2021 03 2021-03-22 1:58
// * Description: No Description
// */
//
//import com.ctrip.framework.apollo.Config;
//import com.ctrip.framework.apollo.ConfigService;
//import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
//import com.utils.ApolloConfigurationChange;
//import com.utils.PropertiesUtils;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
//import java.util.Set;
//
///**
// * Created by tiger on 2018/11/22.
// */
//@Component
////order是用来指定初始顺序，value越小，越早加载
//@Order(value = -9)
//public class InitApolloConfigure implements CommandLineRunner {
//
//    //从apollo获取配置信息
//    @ApolloConfig
//    private Config config;
//
//    /**
//     * commandLineRunner 目的就是在启动之后可以加载所需要的配置文件
//     * */
//    @Override
//    public void run(String... strings) throws Exception {
//        System.out.println("初始化>>>CommandLineRunner");
//        //加载公共配置
//        loadCommonConfig();
//        //加载指定model的配置
//        Set<String> configs = config.getPropertyNames();
//        if(configs != null && ! configs.isEmpty()){
//            configs.forEach(key -> {
//                PropertiesUtils.properties.setProperty(key,config.getProperty(key,null));
//            });
//            //监听app.id中的key发生变化后就改变其值
//            ApolloConfigurationChange.monitorApolloConfigurationChange(PropertiesUtils.properties,config);
//        }
//    }
//
//    /**
//     * 加载公共配置文件
//     * */
//    public void loadCommonConfig(){
//        Config commonConfig = ConfigService.getConfig(PropertiesUtils.COMMON);
//        if(commonConfig != null){
//            for(String key : commonConfig.getPropertyNames()){
//                PropertiesUtils.properties.setProperty(key,commonConfig.getProperty(key,null));
//            }
//            //监听app.id中的key发生变化后就改变其值
//            ApolloConfigurationChange.monitorApolloConfigurationChange(PropertiesUtils.properties,config);
//        }
//    }
//}