package com.example.demo.repository;

import com.example.demo.domain.Student;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class StudentRepositoryTest {

  @Autowired
  private StudentRepository studentRepository;

  private Student student = null;

  @Before
  public void setUp() {
    student = new Student("小明", "0033671", "1");
    studentRepository.save(student);
  }

  @Test
  public void findByName() {
    Student student = studentRepository.findByName(this.student.getName());
    assertThat(student.getName()).isEqualTo("小明");
    assertThat(student.getNumber()).isEqualTo("0033671");
    assertThat(student.getSex()).isEqualTo("1");
  }

  @Test
  public void findOne() {
    Student student = studentRepository.findOne(this.student.getId());
    assertThat(student.getName()).isEqualTo("小明");
    assertThat(student.getNumber()).isEqualTo("0033671");
    assertThat(student.getSex()).isEqualTo("1");
  }
}