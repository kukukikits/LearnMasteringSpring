/*
 * File Name: TaskRepository.java
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

import org.springframework.data.repository.CrudRepository;
import com.masteringspring.bean.Task;

/**
 * CrudRepository接口来自spring data jpa项目，它能自动帮你实现接口中定义的方法，无需自己提供接口实现，
 * 只需要简单地继承CrudRepository然后写上几个需要重写的方法，它就能自动帮你实现
 */

public interface TaskRepository extends CrudRepository<Task, Long>{
    Iterable<Task> findAll();
    long count();
}
