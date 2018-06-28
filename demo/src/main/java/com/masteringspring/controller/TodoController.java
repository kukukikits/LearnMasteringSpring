/*
 * File Name: TodoController.java
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

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masteringspring.bean.Todo;
import com.masteringspring.exception.TodoNotFoundException;
import com.masteringspring.service.TodoService;

import io.swagger.annotations.ApiOperation;

/**
 * 〈一句话功能简述〉 〈功能详细描述〉
 */
@RestController
public class TodoController {
    @Autowired
    private TodoService service;

    @RequestMapping("/users/{name}/todos")
    public List<Todo> retrieveTodos(@PathVariable String name)
    {
        return service.retrieveTodos(name);
    }

    @GetMapping("/users/{name}/todos/{id}")
    public Todo nofoundTodo(@PathVariable String name, @PathVariable int id)
    {
        Todo todo = service.retrieveTodo(id);
        if (null == todo)
        {
            throw new TodoNotFoundException("todo not found");
        }

        return todo;
    }
    
    /**
     * 与hateoas集成后报internal serval error，不知道是什么原因，估计是版本问题
     * @param name
     * @param id
     * @return
     */
    @ApiOperation(value = "与hateoas的集成接口，直接使用浏览器地址请求会返回Internal Server Error，需要加Accept header--application/json才能正常使用",
            response = Resource.class)
     @GetMapping(path = "/hateoas/users/{name}/todos/{id}")
     public Resource<Todo> retrieveTodo(@PathVariable String name,
     @PathVariable int id)
     {
         Todo todo = service.retrieveTodo(id);
         if (todo == null)
         {
             throw new TodoNotFoundException("Todo Not Found");
         }
         Resource<Todo> todoResource = new Resource<Todo>(todo);
         ControllerLinkBuilder linkTo = ControllerLinkBuilder
                 .linkTo(ControllerLinkBuilder.methodOn(this.getClass()).retrieveTodos(name));
         todoResource.add(linkTo.withRel("parent"));

        return todoResource;
    }
}
