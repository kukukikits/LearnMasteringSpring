package com.masteringspring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Welcome {
    @GetMapping("/welcome")
    public String sayHello(){
        String s = "Hello World";
        return s;
    }
}
