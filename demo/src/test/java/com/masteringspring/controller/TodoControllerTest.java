/*
 * File Name: TodoControllerTest.java
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

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.masteringspring.bean.Todo;
import com.masteringspring.service.TodoService;
import static org.mockito.ArgumentMatchers.anyString;
/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 */

@RunWith(SpringRunner.class)
@WebMvcTest(value = TodoController.class, secure = false)
public class TodoControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private TodoService service;
    
    @Test
    public void retrieveTodos() throws Exception{
        List<Todo> mockList = Arrays.asList(new Todo(1, "Jack",
                "Learn Spring MVC", new Date(), false), new Todo(2, "Jack",
                "Learn Struts", new Date(), false));
        
        when(service.retrieveTodos(anyString()))
        .thenReturn(mockList);
        
        MvcResult result = mvc.perform(
                MockMvcRequestBuilders.get("/users/Jack/todos")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();
        String expected = "["
                + "{id:1,user:Jack,desc:\"Learn Spring MVC\",isDone:false}" +","
                + "{id:2,user:Jack,desc:\"Learn Struts\",isDone:false}" + "]";
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString()
                , false);
    }
}
