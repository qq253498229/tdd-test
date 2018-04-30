package com.example.demo.repository;

import com.example.demo.domain.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Package com.example.demo.repository
 * Module
 * Project tdd-test
 * Email 253498229@qq.com
 * Created on 2018/5/1 上午12:44
 *
 * @author wangbin
 */
@Repository
public interface StudentRepository extends CrudRepository<Student, String> {
  /**
   * 通过姓名查询学生
   *
   * @param name 姓名
   * @return 学生
   */
  Student findByName(String name);
}
