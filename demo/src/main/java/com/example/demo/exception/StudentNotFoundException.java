package com.example.demo.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

/**
 * Package com.example.demo.exception
 * Module
 * Project tdd-test
 * Email 253498229@qq.com
 * Created on 2018/5/1 上午12:14
 *
 * @author wangbin
 */
@ResponseStatus(NOT_FOUND)
public class StudentNotFoundException extends RuntimeException {
}
