/*
 * File Name: WelcomeIT.java
 * Copyright: Copyright 2012-2018 CETC52 CETITI All Rights Reserved.
 * Description: 
 * Author: gsb7090
 * Create Date: 2018年6月26日
 * Modifier: gsb7090
 * Modify Date: 2018年6月26日
 * Bugzilla Id: 
 * Modify Content: 
 */
package com.masteringspring.controller;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.masteringspring.DemoApplication;

/**
 * 集成测试，改测试用例会完全启动spring boot服务
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class,
webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WelcomeIT {

    private static final String LOCAL_HOST = "http://localhost:";
    
    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate template;
    public WelcomeIT() {
        // TODO Auto-generated constructor stub
    }
    @Test
    public void welcome(){
        ResponseEntity<String> response = template
                .getForEntity(createURL("/welcome"), String.class);
        assertThat(response.getBody(), equalTo("Hello World"));
    }
    
    private String createURL(String uri){
        return LOCAL_HOST + port + uri;
    }

}
