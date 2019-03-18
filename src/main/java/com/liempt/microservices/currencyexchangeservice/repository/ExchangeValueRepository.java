package com.liempt.microservices.currencyexchangeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.liempt.microservices.currencyexchangeservice.bean.ExchangeValue;

/**
 * @author Liem.pt - 2019/03/18 10:41:10
 *
 */
public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {

	public ExchangeValue findByFromAndTo(String from, String to);
}
