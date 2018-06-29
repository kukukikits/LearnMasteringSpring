/*
 * File Name: ProSpecificConfiguration.java
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

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 */
@Profile("prod")
@Configuration
public class ProSpecificConfiguration {
    
    @Bean
    public String cache(){
        return "Production Cache Configuration -Distributed Cache";
    }
}
