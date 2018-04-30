package com.example.demo.service;

import com.example.demo.domain.Student;
import com.example.demo.exception.StudentNotFoundException;
import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Package com.example.demo.service
 * Module
 * Project tdd-test
 * Email 253498229@qq.com
 * Created on 2018/5/1 上午12:07
 *
 * @author wangbin
 */
@Service
public class StudentService {
  @Resource
  private StudentRepository studentRepository;

  public Student findByName(String s) {
    Student student = studentRepository.findByName(s);
    if (student == null) {
      throw new StudentNotFoundException();
    }
    return student;
  }

  public Student findOne(String id) {
    Student one = studentRepository.findOne(id);
    if (one == null) {
      throw new StudentNotFoundException();
    }
    return one;
  }
}
