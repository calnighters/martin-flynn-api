package com.martinflynn.api.service;

import com.martinflynn.api.dto.TestimonialResponseDto;
import com.martinflynn.api.dto.TestimonialDto;
import com.martinflynn.api.model.Testimonial;
import com.martinflynn.api.repository.TestimonialRepository;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestimonialServiceImpl implements TestimonialService {

  private final TestimonialRepository repository;

  @Override
  public void addEntry(TestimonialDto requestDto) {
    repository.save(Testimonial.builder()
        .name(requestDto.getName())
        .body(requestDto.getBody())
        .rating(requestDto.getRating())
        .enteredDate(LocalDate.now())
        .build());
  }

  @Override
  public TestimonialResponseDto getAllEntries() {
    return TestimonialResponseDto.builder()
        .testimonials(
            StreamSupport
                .stream(repository.findAll().spliterator(), false)
                .map(this::testToDto)
                .sorted(
                    Comparator
                        .comparingInt(TestimonialDto::getRating)
                        .thenComparing(TestimonialDto::getDate)
                        .reversed())
                .collect(Collectors.toList())
        )
        .build();
  }

  private TestimonialDto testToDto(Testimonial testimonial) {
    return TestimonialDto.builder()
        .id(testimonial.getId())
        .rating(testimonial.getRating())
        .body(testimonial.getBody())
        .name(testimonial.getName())
        .date(testimonial.getEnteredDate())
        .build();
  }

  @Override
  public void deleteEntry(Integer id) {
    repository.deleteById(id);
  }
}
