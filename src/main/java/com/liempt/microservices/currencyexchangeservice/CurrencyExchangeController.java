package com.liempt.microservices.currencyexchangeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.liempt.microservices.currencyexchangeservice.bean.ExchangeValue;
import com.liempt.microservices.currencyexchangeservice.repository.ExchangeValueRepository;

/**
 * @author Liem.pt - 2019/03/18 9:28:15
 *
 */
@RestController
public class CurrencyExchangeController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private Environment env;

	@Autowired
	private ExchangeValueRepository repository;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		ExchangeValue ex = repository.findByFromAndTo(from, to);

		ex.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		
		logger.info("{}", ex);

		return ex;
	}
}
