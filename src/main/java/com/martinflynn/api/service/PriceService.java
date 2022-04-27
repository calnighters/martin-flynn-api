package com.martinflynn.api.service;

import com.martinflynn.api.dto.PriceDto;
import com.martinflynn.api.dto.PriceResponseDto;
import com.martinflynn.api.dto.TestimonialResponseDto;
import com.martinflynn.api.dto.TestimonialDto;
import com.martinflynn.api.model.Price;

public interface PriceService {

  void addEntry(PriceDto requestDto);
  
  void updateEntry(PriceDto requestDto);

  PriceResponseDto getAllEntries();

  void deleteEntry(Integer id);
}
