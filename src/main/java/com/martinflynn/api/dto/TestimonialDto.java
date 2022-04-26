package com.martinflynn.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonInclude(Include.NON_NULL)
public class TestimonialDto {

  Integer id;
  String name;
  Integer rating;
  String body;
  LocalDate date;
}
