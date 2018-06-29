/*
 * File Name: InternationalizationConfig.java
 * Copyright: Copyright 2012-2018 CETC52 CETITI All Rights Reserved.
 * Description: 
 * Author: gsb7090
 * Create Date: 2018年6月28日
 * Modifier: gsb7090
 * Modify Date: 2018年6月28日
 * Bugzilla Id: 
 * Modify Content: 
 */
package com.masteringspring.configuration;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/**
 * 国际化配置
 */
@Configuration
public class InternationalizationConfig {

    public InternationalizationConfig() {
        // TODO Auto-generated constructor stub
    }
    @Bean
    public LocaleResolver localeResolver(){
        System.out.println("Locale Resolver is set");
        SessionLocaleResolver sLocaleResolver = new SessionLocaleResolver();
        sLocaleResolver.setDefaultLocale(Locale.US);
        return sLocaleResolver;
    }
    @Bean
    public ResourceBundleMessageSource messageSource(){
        System.out.println("message source is set");
        ResourceBundleMessageSource mSource = new ResourceBundleMessageSource();
        mSource.setBasename("messages");
        mSource.setUseCodeAsDefaultMessage(true);
        return mSource;
    }
}
