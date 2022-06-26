package com.example.securityDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TemplateController {

  @GetMapping
  public String getLoginView() {
    return "login";

  }

  @GetMapping
  public String getCoursesView() {
    return "courses";

  }

}
