package com.example.securityDemo.student;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagementController {

  private static final List<Student> STUDENTS = Arrays.asList(
      new Student(1, "Maria"),
      new Student(2, "jacob"),
      new Student(3, "anna")
  );

  @GetMapping
  public List<Student> getAllStudents() {
    return STUDENTS;
  }

  @GetMapping(path = "{studentId}")
  public Student getStudentById(@PathVariable("studentId") Integer studentId) {
    return STUDENTS
        .stream()
        .filter(student -> student.getStudentId().equals(studentId))
        .findFirst()
        .orElseThrow(() -> new IllegalStateException("Student: " + studentId + "does not exist."));
  }

  @PostMapping
  public void addStudent(@RequestBody Student student) {
    System.out.println("added" + student + "to fake database");
    STUDENTS.add(new Student(student.getStudentId(), student.getStudentName()));
  }


  @DeleteMapping(path = "{studentId}")
  public void deleteStudent(Integer studentId) {
    System.out.println("deleted" + studentId);
  }

  @PutMapping(path = "{studentId}")
  public void updateStudent(Integer studentId, Student student){
    System.out.println(String.format("%s %s", studentId, student));
  }


}
