package com.martinflynn.api.service;

import com.martinflynn.api.dto.TestimonialResponseDto;
import com.martinflynn.api.dto.TestimonialDto;

public interface TestimonialService {

  void addEntry(TestimonialDto requestDto);

  TestimonialResponseDto getAllEntries();

  void deleteEntry(Integer id);
}
