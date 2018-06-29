/*
 * File Name: TaskRepositoryTest.java
 * Copyright: Copyright 2012-2018 CETC52 CETITI All Rights Reserved.
 * Description: 
 * Author: gsb7090
 * Create Date: 2018年6月28日
 * Modifier: gsb7090
 * Modify Date: 2018年6月28日
 * Bugzilla Id: 
 * Modify Content: 
 */
package com.masteringspring.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.masteringspring.bean.Task;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 */
@DataJpaTest
@RunWith(SpringRunner.class)
public class TaskRepositoryTest {
    @Autowired
    private TaskRepository taskRepository;
    public TaskRepositoryTest() {
        // TODO Auto-generated constructor stub
    }
    @Test
    public void check_task_count(){
        assertEquals(3, taskRepository.count());
    }
    @Test
    public void findOne(){
        Optional<Task> task = taskRepository.findById(101L);
        
        assertEquals("Todo Desc 1", task.get().getDescription());
    }
    @Test
    public void exist(){
        assertFalse(taskRepository.existsById(105L));
        assertTrue(taskRepository.existsById(101L));
    }
    @Test
    public void delete(){
        taskRepository.deleteById(101L);
        assertEquals(2, taskRepository.count());
    }
    @Test
    public void deleteAll(){
        taskRepository.deleteAll();
        assertEquals(0, taskRepository.count());
    }
    @Autowired
    TestEntityManager entityManager;
    @Test
    public void save(){
        Task task = taskRepository.findById(101L).get();
        task.setDescription("Task Desc Updated");
        taskRepository.save(task);
        entityManager.flush();
        Task updTask = taskRepository.findById(101L).get();
        assertEquals("Task Desc Updated", updTask.getDescription());
    }
}
