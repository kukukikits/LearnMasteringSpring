/*
 * File Name: Todo.java
 * Copyright: Copyright 2012-2018 CETC52 CETITI All Rights Reserved.
 * Description: 
 * Author: gsb7090
 * Create Date: 2018年6月26日
 * Modifier: gsb7090
 * Modify Date: 2018年6月26日
 * Bugzilla Id: 
 * Modify Content: 
 */
package com.masteringspring.bean;

import java.util.Date;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 */

public class Todo {

    public Todo() {
        // TODO Auto-generated constructor stub
    }
    public Todo(int id, String user, String desc, Date date, boolean isDone){
        this.id = id;
        this.user = user;
        this.desc = desc;
        this.targetDate = date;
        this.isDone = isDone;
    }
    private int id;
    private String user;
    private String desc;
    private Date targetDate;
    private boolean isDone;
    
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getUser()
    {
        return user;
    }

    public void setUser(String user)
    {
        this.user = user;
    }
    /**
     * @return the desc
     */
    public String getDesc()
    {
        return desc;
    }
    /**
     * @param desc the desc to set
     */
    public void setDesc(String desc)
    {
        this.desc = desc;
    }
    /**
     * @return the targetDate
     */
    public Date getTargetDate()
    {
        return targetDate;
    }
    /**
     * @param targetDate the targetDate to set
     */
    public void setTargetDate(Date targetDate)
    {
        this.targetDate = targetDate;
    }

    public boolean getIsDone()
    {
        return isDone;
    }
    public void setIsDone(boolean isDone){
        this.isDone = isDone;
    }
}
