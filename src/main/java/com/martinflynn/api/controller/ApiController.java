package com.martinflynn.api.controller;

import com.martinflynn.api.dto.GetResponseDto;
import com.martinflynn.api.dto.TestimonialDto;
import com.martinflynn.api.service.ApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "*"})
@RequestMapping("/martin-flynn")
@RequiredArgsConstructor
public class ApiController {

  private final ApiService apiService;

  @PostMapping
  public void addEntry(@RequestBody TestimonialDto requestDto) {
    apiService.addEntry(requestDto);
  }

  @GetMapping
  public GetResponseDto getEntries() {
    return apiService.getAllEntries();
  }

  @DeleteMapping(path = "/{id}")
  public void deleteEntry(@PathVariable Integer id) {
    apiService.deleteEntry(id);
  }
}
