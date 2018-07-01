package com.learn.mastering.spring.serviceconsumer;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "microservice-a")
public interface MicroserviceAProxy {
    @RequestMapping(value = "random", method = RequestMethod.GET)
    public List<Integer> getRandomNumbers();
}
