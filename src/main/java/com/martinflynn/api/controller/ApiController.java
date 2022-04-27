package com.martinflynn.api.controller;

import com.martinflynn.api.dto.PriceDto;
import com.martinflynn.api.dto.PriceResponseDto;
import com.martinflynn.api.dto.TestimonialResponseDto;
import com.martinflynn.api.dto.TestimonialDto;
import com.martinflynn.api.service.PriceService;
import com.martinflynn.api.service.TestimonialService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://localhost:3000",
    "https://martin-flynn-driver-training.netlify.app"})
@RequestMapping("/martin-flynn")
@RequiredArgsConstructor
public class ApiController {

  private final TestimonialService testimonialService;
  private final PriceService priceService;

  @PostMapping(path = "/testimonial")
  public void addTestimonialEntry(@RequestBody TestimonialDto requestDto) {
    testimonialService.addEntry(requestDto);
  }

  @GetMapping(path = "/testimonial")
  public TestimonialResponseDto getTestimonialEntries() {
    return testimonialService.getAllEntries();
  }

  @DeleteMapping(path = "/testimonial/{id}")
  public void deleteTestimonialEntry(@PathVariable Integer id) {
    testimonialService.deleteEntry(id);
  }

  @PostMapping(path = "/price")
  public void addPriceEntry(@RequestBody PriceDto requestDto) {
    priceService.addEntry(requestDto);
  }

  @PutMapping(path = "/price")
  public void updatePriceEntry(@RequestBody PriceDto requestDto) {
    priceService.updateEntry(requestDto);
  }

  @GetMapping(path = "/price")
  public PriceResponseDto getPriceEntries() {
    return priceService.getAllEntries();
  }

  @DeleteMapping(path = "/price/{id}")
  public void deletePriceEntry(@PathVariable Integer id) {
    priceService.deleteEntry(id);
  }
}
