package com.masteringspring.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.masteringspring.service.CustomApplicationPropertiesService;
import com.masteringspring.service.EnvSpecificService;

@RestController
public class Welcome {
    @Autowired
    private MessageSource msgSource;
    @Autowired
    private CustomApplicationPropertiesService cService;
    @Autowired
    private EnvSpecificService envService;
    
    @GetMapping("/welcome")
    public String sayHello(){
        String s = "Hello World hah";
        return s;
    }
    @GetMapping("/welcome-internationalized")
    public String msg(@RequestHeader(value="Accept-Language", required = false)
    Locale locale){
        return msgSource.getMessage("welcome.message", null, locale);
    }
    @GetMapping("/customService")
    public String cumtomProperties(){
        return cService.retrieveSomeData();
    }
    @GetMapping("/getEnvCache")
    public String envString(){
        return envService.getEnvDependCache();
    }
}
