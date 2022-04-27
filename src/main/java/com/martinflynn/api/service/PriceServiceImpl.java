package com.martinflynn.api.service;

import com.martinflynn.api.dto.PriceDto;
import com.martinflynn.api.dto.PriceResponseDto;
import com.martinflynn.api.dto.TestimonialResponseDto;
import com.martinflynn.api.dto.TestimonialDto;
import com.martinflynn.api.exceptions.NotFoundException;
import com.martinflynn.api.model.Price;
import com.martinflynn.api.model.Testimonial;
import com.martinflynn.api.repository.PriceRepository;
import com.martinflynn.api.repository.TestimonialRepository;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PriceServiceImpl implements PriceService {

  private final PriceRepository repository;

  @Override
  public void addEntry(PriceDto requestDto) {
    repository.save(Price.builder()
        .type(requestDto.getType())
        .price(requestDto.getPrice())
        .build());
  }

  @Override
  public void updateEntry(PriceDto requestDto) {
    Price price = repository.findById(requestDto.getId()).orElseThrow(
        () -> new NotFoundException("Price not found for record ID: " + requestDto.getId()));
    price.setType(price.getType());
    price.setPrice(requestDto.getPrice());
    repository.save(price);
  }

  @Override
  public PriceResponseDto getAllEntries() {
    return PriceResponseDto.builder()
        .prices(
            StreamSupport
                .stream(repository.findAll().spliterator(), false)
                .map(this::priceToDto)
                .sorted(
                    Comparator
                        .comparingInt(PriceDto::getId)
                        .reversed())
                .collect(Collectors.toList())
        )
        .build();
  }

  @Override
  public void deleteEntry(Integer id) {
    repository.deleteById(id);
  }
  
  private PriceDto priceToDto(Price price) {
    return PriceDto.builder()
        .id(price.getId())
        .type(price.getType())
        .price(price.getPrice())
        .build();
  }

}
