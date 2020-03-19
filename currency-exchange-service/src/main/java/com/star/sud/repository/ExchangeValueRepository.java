package com.star.sud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.star.sud.dto.ExchangeValue;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {

	ExchangeValue getByFromAndTo(String from, String to);

}
