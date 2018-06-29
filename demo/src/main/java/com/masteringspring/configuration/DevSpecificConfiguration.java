/*
 * File Name: DevSpecificConfiguration.java
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
 * All classes marked with @Component or
 * @Configuration can also be marked with an additional @Profile annotation to
 * specify the profile in which the bean or configuration is enabled.
 */
@Profile("dev")
@Configuration
public class DevSpecificConfiguration {
    @Bean
    public String cache(){
        return "Dev Cache Configuration";
    }
}
