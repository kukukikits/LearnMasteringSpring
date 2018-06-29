/*
 * File Name: User.java
 * Copyright: Copyright 2012-2018 CETC52 CETITI All Rights Reserved.
 * Description: 
 * Author: gsb7090
 * Create Date: 2018年6月28日
 * Modifier: gsb7090
 * Modify Date: 2018年6月28日
 * Bugzilla Id: 
 * Modify Content: 
 */
package com.masteringspring.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 */
@Entity
@NamedQuery(name = "User.findUsersWithNameUsingNamedQuery",
query = "select u from User u where u.name = ?1")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userid;
    private String name;
    @OneToMany(mappedBy = "user")
    private List<Task> tasks;

    public User() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @param userid
     * @param name
     * @param tasks
     */
    public User(String userid, String name, List<Task> tasks) {
        super();
        this.userid = userid;
        this.name = name;
        this.tasks = tasks;
    }

    public List<Task> getTasks()
    {
        return tasks;
    }

    public void setTasks(List<Task> tasks)
    {
        this.tasks = tasks;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getUserid()
    {
        return userid;
    }

    public void setUserid(String userid)
    {
        this.userid = userid;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return String.format("User [id=%s, userid=%s, name=%s, tasks=%s]", id, userid, name, tasks);
    }
    
}
