package com.example.demo.controller;

import com.example.demo.domain.Student;
import com.example.demo.exception.StudentNotFoundException;
import com.example.demo.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Package com.example.demo.controller
 * Module
 * Project tdd-test
 * Email 253498229@qq.com
 * Created on 2018/4/30 下午11:55
 *
 * @author wangbin
 */
@RunWith(SpringRunner.class)
@WebMvcTest(StudentController.class)
public class StudentControllerTest {

  @Autowired
  private MockMvc mockMvc;
  @MockBean
  private StudentService studentService;

  @Test
  public void findOne() throws Exception {
    given(studentService.findOne(anyString())).willReturn(new Student("1", "小明", "0033671", "1"));

    mockMvc.perform(MockMvcRequestBuilders.get("/student/{id}", "1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("name").value("小明"))
            .andExpect(jsonPath("number").value("0033671"))
            .andExpect(jsonPath("sex").value("1"))
    ;
  }

  @Test
  public void findOneNotFoundException() throws Exception {
    given(studentService.findOne(anyString())).willThrow(new StudentNotFoundException());
    mockMvc.perform(MockMvcRequestBuilders.get("/student/{id}", "1"))
            .andExpect(status().isNotFound());
  }

  @Test
  public void findByName() throws Exception {
    given(studentService.findByName(anyString())).willReturn(new Student("小明", "0033671", "1"));

    mockMvc.perform(MockMvcRequestBuilders.get("/student/name/{name}", "小明"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("name").value("小明"))
            .andExpect(jsonPath("number").value("0033671"))
            .andExpect(jsonPath("sex").value("1"))
    ;
  }

  @Test
  public void findByNameNotFoundException() throws Exception {
    given(studentService.findByName(anyString())).willThrow(new StudentNotFoundException());
    mockMvc.perform(MockMvcRequestBuilders.get("/student/name/{id}", "小明"))
            .andExpect(status().isNotFound());
  }


}
