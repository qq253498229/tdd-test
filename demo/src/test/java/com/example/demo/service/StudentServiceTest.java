package com.example.demo.service;

import com.example.demo.domain.Student;
import com.example.demo.exception.StudentNotFoundException;
import com.example.demo.repository.StudentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyString;

/**
 * Mock自动注入
 * InjectMocks自动注入并带上依赖
 */
@RunWith(MockitoJUnitRunner.class)
public class StudentServiceTest {

  @Mock
  private StudentRepository studentRepository;

  @InjectMocks
  private StudentService studentService;

  @Test
  public void findOne() {
    given(studentRepository.findOne(anyString())).willReturn(new Student("1", "小明", "0033671", "1"));

    Student student = studentService.findOne(anyString());
    assertThat(student.getName()).isEqualTo("小明");
    assertThat(student.getNumber()).isEqualTo("0033671");
    assertThat(student.getSex()).isEqualTo("1");
  }

  @Test(expected = StudentNotFoundException.class)
  public void findOneNotFound() {
    given(studentRepository.findOne(anyString())).willReturn(null);

    studentService.findByName(anyString());

  }


  @Test
  public void findByName() {
    given(studentRepository.findByName(anyString())).willReturn(new Student("小明", "0033671", "1"));

    Student student = studentService.findByName(anyString());
    assertThat(student.getName()).isEqualTo("小明");
    assertThat(student.getNumber()).isEqualTo("0033671");
    assertThat(student.getSex()).isEqualTo("1");
  }

  @Test(expected = StudentNotFoundException.class)
  public void findByNameNotFound() {
    given(studentRepository.findByName(anyString())).willReturn(null);

    studentService.findByName(anyString());

  }
}