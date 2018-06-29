package com.learn.mastering.spring.microservicea.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.mastering.spring.microservicea.configuration.ApplicationConfiguration;
@RestController
public class MessageController {
    @Autowired
    private ApplicationConfiguration configuration;

    @RequestMapping("/message")
    public Map<String, String> welcome()
    {
        Map<String, String> map = new HashMap<String, String>();
        map.put("message", configuration.getMessage());
        return map;
    }
}
