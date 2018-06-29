/*
 * File Name: CustomApplicationPropertiesService.java
 * Copyright: Copyright 2012-2018 CETC52 CETITI All Rights Reserved.
 * Description: 
 * Author: gsb7090
 * Create Date: 2018年6月28日
 * Modifier: gsb7090
 * Modify Date: 2018年6月28日
 * Bugzilla Id: 
 * Modify Content: 
 */
package com.masteringspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.masteringspring.configuration.ApplicationProperties;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 */
@Service
public class CustomApplicationPropertiesService {
    @Autowired
    private ApplicationProperties properties;

    public String retrieveSomeData(){
        
        System.out.println(properties.isEnableSwitchForService1());
        System.out.println(properties.getServiceTimeout());
        System.out.println(properties.getServiceURL());
        return String.format("service %s with %ss timeout is enabled: %s", 
                properties.getServiceURL(), properties.getServiceTimeout(),                properties.isEnableSwitchForService1());
    }
}
