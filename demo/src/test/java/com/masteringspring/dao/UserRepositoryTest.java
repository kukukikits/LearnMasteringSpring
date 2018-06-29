/*
 * File Name: UserRepositoryTest.java
 * Copyright: Copyright 2012-2018 CETC52 CETITI All Rights Reserved.
 * Description: 
 * Author: gsb7090
 * Create Date: 2018年6月29日
 * Modifier: gsb7090
 * Modify Date: 2018年6月29日
 * Bugzilla Id: 
 * Modify Content: 
 */
package com.masteringspring.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import com.masteringspring.bean.User;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 */
@DataJpaTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;
    @Autowired
    TestEntityManager testEntityManager;
    @Test
    public void testing_sort_stuff(){
        Sort sort = new Sort(Sort.Direction.DESC, "name")
                .and(new Sort(Sort.Direction.ASC, "userid"));
        
        Iterable<User> users = userRepository.findAll(sort);
        for (User user : users)
        {
            System.out.println(user);
        }
    }
    @Test
    public void using_pageable_stuff(){
        PageRequest pageable = new PageRequest(0, 2);
        Page<User> userPage = userRepository.findAll(pageable);
        System.out.println(userPage);
        System.out.println(userPage.getContent());
    }
    @Test
    public void using_auto_implemented_query_methods(){
        List<User> users = userRepository.findByName("User Name 3");
        assertEquals("User Name 3", users.get(0).getName());
        
        List<User> users2 = userRepository.findByNameUsingQuery("User Name 3");
        assertEquals("User Name 3", users2.get(0).getName());
        
        List<User> users3 = userRepository.findUsersByNameNativeQuery("User Name 3");
        assertEquals("User Name 3", users3.get(0).getName());
    }
}
