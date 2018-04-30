package com.example.demo.controller;

import com.example.demo.domain.Student;
import com.example.demo.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Package com.example.demo.controller
 * Module
 * Project tdd-test
 * Email 253498229@qq.com
 * Created on 2018/4/30 下午11:57
 *
 * @author wangbin
 */
@RestController
public class StudentController {
  @Resource
  private StudentService studentService;

  @GetMapping("/student/{id}")
  public Student findOne(@PathVariable("id") String id) {
    return studentService.findOne(id);
  }

  @GetMapping("/student/name/{name}")
  public Student findByName(@PathVariable("name") String name) {
    return studentService.findByName(name);
  }
}
