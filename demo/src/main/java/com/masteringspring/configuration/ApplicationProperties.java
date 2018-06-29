/*
 * File Name: ApplicationProperties.java
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

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 获取自定义application.properties中的配置属性
 */
@Component

//绑定以application为前缀的外部配置
@ConfigurationProperties("application")
public class ApplicationProperties {
    private boolean enableSwitchForService1;
    private String serviceURL;
    private int serviceTimeout;
    
    public boolean isEnableSwitchForService1()
    {
        return enableSwitchForService1;
    }
    public void setEnableSwitchForService1(boolean enableSwitchForService1)
    {
        this.enableSwitchForService1 = enableSwitchForService1;
    }
    public int getServiceTimeout()
    {
        return serviceTimeout;
    }
    public void setServiceTimeout(int serviceTimeout)
    {
        this.serviceTimeout = serviceTimeout;
    }
    
    public String getServiceURL()
    {
        return serviceURL;
    }
    public void setServiceURL(String serviceURL)
    {
        this.serviceURL = serviceURL;
    }
}
