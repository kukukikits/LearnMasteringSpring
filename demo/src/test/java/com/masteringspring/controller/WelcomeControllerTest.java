package com.masteringspring.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)

/**
 * 使用WebMvcTest时，Spring Boot is only instantiating the web layer
 */
@WebMvcTest(value = Welcome.class, secure = false)
public class WelcomeControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void sayHello() throws Exception {

        mvc.perform(
                MockMvcRequestBuilders.get("/welcome")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Hello World"));
    }
}
