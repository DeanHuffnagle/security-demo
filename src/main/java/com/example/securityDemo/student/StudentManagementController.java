package com.example.securityDemo.student;

import com.example.securityDemo.security.ApplicationUserRole;
import org.springframework.security.access.prepost.PreAuthorize;
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
  @PreAuthorize("hasAnyRole(ROLE_ADMIN', 'ROLE_ADMIN_TRAINEE')")
  public List<Student> getAllStudents() {
    return STUDENTS;
  }

  @GetMapping(path = "{studentId}")
  @PreAuthorize("hasAnyRole(ROLE_ADMIN', 'ROLE_ADMIN_TRAINEE')")
  public Student getStudentById(@PathVariable("studentId") Integer studentId) {
    return STUDENTS
        .stream()
        .filter(student -> student.getStudentId().equals(studentId))
        .findFirst()
        .orElseThrow(() -> new IllegalStateException("Student: " + studentId + "does not exist."));
  }

  @PostMapping
  @PreAuthorize("hasAuthority('student:write')")
  public void addStudent(@RequestBody Student student) {
    System.out.println("added " + student.toString() + " to fake database");

  }


  @DeleteMapping(path = "{studentId}")
  @PreAuthorize("hasAuthority('student:write')")
  public void deleteStudent(@PathVariable("studentId") Integer studentId) {
    System.out.println("deleted " + studentId);
  }

  @PutMapping(path = "{studentId}")
  @PreAuthorize("hasAuthority('student:write')")
  public void updateStudent(@PathVariable("studentId") Integer studentId, @RequestBody Student student){
    System.out.println(String.format("id: %s, name: %s", studentId, student.getStudentName()));
  }


}
