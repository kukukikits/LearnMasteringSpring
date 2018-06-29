/*
 * File Name: RandomNumberController.java
 * Copyright: Copyright 2012-2018 CETC52 CETITI All Rights Reserved.
 * Description: 
 * Author: gsb7090
 * Create Date: 2018年6月29日
 * Modifier: gsb7090
 * Modify Date: 2018年6月29日
 * Bugzilla Id: 
 * Modify Content: 
 */
package com.learn.mastering.spring.microservicea.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 〈一句话功能简述〉 〈功能详细描述〉
 */

public class RandomNumberController {
    private Log log = LogFactory.getLog(RandomNumberController.class);

    @RequestMapping("/random")
    public List<Integer> random()
    {
        List<Integer> numbers = new ArrayList<Integer>();
        for (int i = 1; i <= 5; i++)
        {
            numbers.add(generateRandomNumber());
        }
        log.warn("Returning " + numbers);
        return numbers;
    }

    private int generateRandomNumber()
    {
        return (int) (Math.random() * 1000);
    }
}
