package com.martinflynn.api.service;

import com.martinflynn.api.dto.GetResponseDto;
import com.martinflynn.api.dto.TestimonialDto;

public interface ApiService {

  void addEntry(TestimonialDto requestDto);

  GetResponseDto getAllEntries();

  void deleteEntry(Integer id);
}
