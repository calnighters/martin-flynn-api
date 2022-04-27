package com.martinflynn.api.repository;

import com.martinflynn.api.model.Price;
import org.springframework.data.repository.CrudRepository;

public interface PriceRepository extends CrudRepository<Price, Integer> {

}
