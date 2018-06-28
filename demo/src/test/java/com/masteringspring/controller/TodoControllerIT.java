/*
 * File Name: TodoControllerIT.java
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

import java.nio.charset.Charset;
import java.util.Base64;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.test.context.junit4.SpringRunner;

import com.masteringspring.DemoApplication;

/**
 * 〈一句话功能简述〉 〈功能详细描述〉
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class TodoControllerIT {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate template;

    HttpHeaders headers = createHeaders("admin", "123456");
    
    @Test
    public void retrieveTodos() throws JSONException
    {
        String expected = "[" + "{id:1,user:Jack,desc:\"Learn Spring MVC\",isDone:false}" + ","
                + "{id:2,user:Jack,desc:\"Learn Struts\",isDone:false}" + "]";
        String uri = "/users/Jack/todos";
        //ResponseEntity<String> response = template.getForEntity(createUrl(uri), String.class);
        
        ResponseEntity<String> response = template.exchange(
                createUrl(uri), HttpMethod.GET, 
                new HttpEntity<String>(null, headers), String.class);
        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

    private String createUrl(String uri)
    {
        return "http://localhost:" + port + uri;
    }
    
    /**
     * 在默认设置下，登录认证是基于HTTP头部想消息进行的
     */
    private HttpHeaders createHeaders(String name, String password){
        
        //返回HttpHeaders的匿名类实例
        return new HttpHeaders() {
            {
                String auth = name + ":" + password;
                byte[] encodeAuth = Base64.getEncoder().encode(
                        auth.getBytes(Charset.forName("US-ASCII")));
                String authHeader = "Basic " + new String(encodeAuth);
                set("Authorization", authHeader);
            }
        };
    }
    
    @Test
    public void retrieveTodosByOuath2() throws JSONException{
        String expected = "[" + "{id:1,user:Jack,desc:\"Learn Spring MVC\",isDone:false}" + ","
                + "{id:2,user:Jack,desc:\"Learn Struts\",isDone:false}" + "]";
        String uri = "/users/Jack/todos";
        
        ResourceOwnerPasswordResourceDetails resource = 
                new ResourceOwnerPasswordResourceDetails();
        resource.setUsername("admin");
        resource.setPassword("password");
        resource.setAccessTokenUri(createUrl("/oauth/token"));
        resource.setClientId("acme");
        resource.setClientSecret("secret");
        resource.setGrantType("password");
        OAuth2RestTemplate oauthTemplate = new OAuth2RestTemplate(resource, 
                new DefaultOAuth2ClientContext());
        
        ResponseEntity<String> response = oauthTemplate.getForEntity(
                createUrl(uri), String.class);
        JSONAssert.assertEquals(expected, response.getBody(), false);
        
    }
}
