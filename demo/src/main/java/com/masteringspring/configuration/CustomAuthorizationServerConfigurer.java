/*
 * File Name: CustomAuthorizationServerConfigurer.java
 * Copyright: Copyright 2012-2018 CETC52 CETITI All Rights Reserved.
 * Description: 
 * Author: gsb7090
 * Create Date: 2018年6月27日
 * Modifier: gsb7090
 * Modify Date: 2018年6月27日
 * Bugzilla Id: 
 * Modify Content: 
 */
package com.masteringspring.configuration;

import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.stereotype.Component;

/**
 * 下面这个怎么都配置,都不能配置password密码模式，应该还需要配置其他的东西，详情见https://segmentfault.com/a/1190000012260914#articleHeader1
 * 而直接在application.properties里配置的则可以支持
 */
//@Component 若使用该java配置，需加上@component注解
public class CustomAuthorizationServerConfigurer extends AuthorizationServerConfigurerAdapter{

    
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
            
            .withClient("acme")
            .secret("secret")
            .authorizedGrantTypes("client_credentials", "password", "refresh_token")
            .scopes("all");
    }
}
