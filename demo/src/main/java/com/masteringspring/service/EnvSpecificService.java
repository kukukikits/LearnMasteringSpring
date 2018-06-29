/*
 * File Name: EnvSpecificService.java
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
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * 获取外部配置数据
 */
@Service
public class EnvSpecificService {
    
    /**
     * 自动装配name为cache的bean，改bean是DevSpecificConfiguration/ProSpecificConfiguration提供的
     */
    @Autowired
    @Qualifier("cache")
    private String cache;
    public String getEnvDependCache(){
        return cache;
    }

}
