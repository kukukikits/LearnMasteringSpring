/*
 * File Name: TodoService.java
 * Copyright: Copyright 2012-2018 CETC52 CETITI All Rights Reserved.
 * Description: 
 * Author: gsb7090
 * Create Date: 2018年6月26日
 * Modifier: gsb7090
 * Modify Date: 2018年6月26日
 * Bugzilla Id: 
 * Modify Content: 
 */
package com.masteringspring.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.masteringspring.bean.Todo;

/**
 * 〈一句话功能简述〉 〈功能详细描述〉
 */
@Service
public class TodoService {

    public TodoService() {
        // TODO Auto-generated constructor stub
    }

    private static List<Todo> todos = new ArrayList<Todo>();
    private static int todoCount = 3;
    static
    {
        todos.add(new Todo(1, "Jack", "Learn Spring MVC", new Date(), false));
        todos.add(new Todo(2, "Jack", "Learn Struts", new Date(), false));
        todos.add(new Todo(3, "Jill", "Learn Hibernate", new Date(), false));
    }

    @Cacheable("todos")
    public List<Todo> retrieveTodos(String user)
    {
        List<Todo> filteredTodos = new ArrayList<Todo>();
        for (Todo todo : todos)
        {
            if (todo.getUser().equals(user))
                filteredTodos.add(todo);
        }
        return filteredTodos;
    }

    public Todo addTodo(String name, String desc, Date targetDate, boolean isDone)
    {
        Todo todo = new Todo(++todoCount, name, desc, targetDate, isDone);
        todos.add(todo);
        return todo;
    }

    public Todo retrieveTodo(int id)
    {
        for (Todo todo : todos)
        {
            if (todo.getId() == id)
                return todo;
        }
        return null;
    }
}
