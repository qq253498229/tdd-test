package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Package com.example.demo.domain
 * Module
 * Project tdd-test
 * Email 253498229@qq.com
 * Created on 2018/4/30 下午11:49
 *
 * @author wangbin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Student {

  @Id
  @GenericGenerator(strategy = "uuid", name = "uuid")
  @GeneratedValue(generator = "uuid")
  private String id;
  /**
   * 姓名
   */
  private String name;
  /**
   * 学号
   */
  private String number;
  /**
   * 性别，1男2女0其它
   */
  private String sex;

  public Student(String name, String number, String sex) {

    this.name = name;
    this.number = number;
    this.sex = sex;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }
}
