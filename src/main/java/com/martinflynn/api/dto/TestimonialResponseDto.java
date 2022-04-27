package com.martinflynn.api.dto;

import java.util.List;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class TestimonialResponseDto {

  List<TestimonialDto> testimonials;
}
