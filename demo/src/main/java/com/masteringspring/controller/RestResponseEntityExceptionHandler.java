/*
 * File Name: RestResponseEntityExceptionHandler.java
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

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.masteringspring.bean.ExceptionResponse;
import com.masteringspring.exception.TodoNotFoundException;

/**
 * 自定义controller层的Exception处理器
 */

@ControllerAdvice
@RestController
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
    
    /**
     * 处理所有在controller层抛出的TodoNotFoundException类型事件
     * @param ex
     * @return
     */
    @ExceptionHandler(TodoNotFoundException.class)
    public final ResponseEntity<ExceptionResponse> todoNotFound(TodoNotFoundException ex){
        ExceptionResponse response = new ExceptionResponse(ex.getMessage(), 
                "Any details you would want to add");
        return new ResponseEntity<ExceptionResponse>(response, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

}
