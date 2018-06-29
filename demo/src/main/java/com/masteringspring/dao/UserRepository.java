/*
 * File Name: UserRepository.java
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

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.masteringspring.bean.User;
import java.lang.Long;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 */
@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends PagingAndSortingRepository<User, Long>{
    //以下方法的名称遵守了Spring JPA的命名规则，我们无需自己实现这些方法，Spring JPA帮我们自动实现了下面的这些方法
    List<User> findByName(String name);                     //pattern: findBy** 或者 queryBy** 或者 getBy** 三者等同
    List<User> findByName(String name, Sort sort);
    List<User> findByName(String name, Pageable pageable);
    
    Long countByName(String name);                          //pattern: countBy**
    Long deleteByName(String name);                         //pattern: deleteBy** 或者 removeBy**  二者等同
    List<User> removeByName(String name);

    //User中包含了Tasks元素，可以使用Task的属性进行查询，pattern: findBy + User中的变量名 + 该变量的属性
    List<User> findByTasksTitle(String title);     
    
    //findFirstBy**, findTopBy**: Queries for the first user
    User findFirstByName(String name);
    User findTopByName(String name);
    
    //findTop3By**, findFirst3By**: Finds the top three users
    List<User> findTop3ByName(String name);
    List<User> findFirst3ByName(String name);
    
    List<User> findByNameAndUserid(String name, String userid);  //使用多个属性查询
    List<User> findDistinctUserByNameOrUserid(String name, String userid); //找到与name和id都匹配的不同的User
    List<User> findByNameIgnoreCase(String name); //忽略大小写
    List<User> findByNameOrderByIdDesc(String name); //将查询结果以id降序排列
    //END 以上的方法都遵循一定的语法模板，这样Spring JPA才能自动创建
    
    //自己写查询语句：方法一
    @Query("select u from User u where u.name = ?1") //？1代表下面方法中的第一个参数
    List<User> findByNameUsingQuery(String name);
    
    //自己写查询语句：方法二
    @Query("select u from User u where u.name = :name") //:name代表方法中使用@Param命名的参数
    List<User> findByNameUsingNamedParameters(@Param("name") String name);
    
    //自己写查询语句：方法二, query语句写在User的@NamedQuery注解里了，要使下面的方法名和那边对应起来
    List<User> findUsersWithNameUsingNamedQuery(String name);
    
    //
    @Query(value = "SELECT * FROM USER WHERE name = ?1", nativeQuery = true)
    List<User> findUsersByNameNativeQuery(String name);
}
