package com.martinflynn.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/martin-flynn")
public class ApiController {

  @GetMapping
  public String test() {
    return "test";
  }
}
