package com;

import com.ctrip.framework.apollo.ConfigChangeListener;
import com.ctrip.framework.apollo.ConfigService;
import com.ctrip.framework.apollo.model.ConfigChange;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import javax.annotation.Resource;

/**
 * @Description
 * @Package com
 * @ClassName 启动
 * @Copyright: Copyright (c) 2020
 * @Date 2021-02-06 23:48
 * @Company www.peachfully.com.cn
 * @Author 桃我喜欢
 * @Version 1.0
 */
@EnableApolloConfig({"TEST1.mysql.database","TEST1.application.secret","application"})
@SpringBootApplication
@ServletComponentScan
@MapperScan("com.mapper")
public class SpringApp{
    public static void main(String[] args){
        SpringApplication.run(SpringApp.class);
        System.out.println("============ application end =============");
        // 手动配置 apolloConfigListener，添加配置改动监听
        ConfigChangeListener configChangeListener = configChangeEvent -> {
            ConfigChange change;
            for (String key : configChangeEvent.changedKeys()) {
                change = configChangeEvent.getChange(key);
                // 打印改动的配置信息
                System.out.println(
                        String.format(String.format("Change - key: %s, oldValue: %s, newValue: %s, changeType: %s",
                                change.getPropertyName(), change.getOldValue(), change.getNewValue(),
                                change.getChangeType())));
            }
        };
        // 也可@ApolloConfig注入
        ConfigService.getAppConfig().addChangeListener(configChangeListener);
    }
}
