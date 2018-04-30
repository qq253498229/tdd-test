package com.example.demo;

import com.example.demo.domain.Student;
import com.example.demo.repository.StudentRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.OK;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class DemoApplicationTests {

  @Autowired
  private TestRestTemplate restTemplate;

  @Autowired
  private StudentRepository studentRepository;

  private Student student;
  private Student student1;

  @Before
  public void setUp() {
    student = new Student("小明", "0033671", "1");
    studentRepository.save(student);
    student1 = new Student("小明", "0033672", "2");
    studentRepository.save(student1);
  }

  @After
  public void tearDown() {
    studentRepository.delete(student.getId());
    studentRepository.delete(student1.getId());
  }

  @Test
  public void contextLoads() {
    ResponseEntity<Student> response = restTemplate.getForEntity("/student/{id}", Student.class, student.getId());
    assertThat(response.getStatusCode()).isEqualTo(OK);
    assertThat(response.getBody().getName()).isEqualTo("小明");
    assertThat(response.getBody().getNumber()).isEqualTo("0033671");
    assertThat(response.getBody().getSex()).isEqualTo("1");

    ResponseEntity<Student> response1 = restTemplate.getForEntity("/student/name/{id}", Student.class, student.getName());
    assertThat(response1.getStatusCode()).isEqualTo(INTERNAL_SERVER_ERROR);
  }

}
