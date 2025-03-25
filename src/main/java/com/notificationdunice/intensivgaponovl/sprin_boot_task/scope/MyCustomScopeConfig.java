package com.notificationdunice.intensivgaponovl.sprin_boot_task.scope;

import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class MyCustomScopeConfig {

    @Bean
    public CustomScopeConfigurer customScopeConfigurer() {
        CustomScopeConfigurer customScopeConfigurer = new CustomScopeConfigurer();
        Map<String, Object> scopeMap = new HashMap<>();
        scopeMap.put("myTreadScope", new MyCustomThreadScope());
        customScopeConfigurer.setScopes(scopeMap);
        return customScopeConfigurer;
    }
}
