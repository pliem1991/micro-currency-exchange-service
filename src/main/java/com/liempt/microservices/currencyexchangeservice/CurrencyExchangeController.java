package com.liempt.microservices.currencyexchangeservice;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.liempt.microservices.currencyexchangeservice.bean.ExchangeValue;

/**
 * @author Liem.pt - 2019/03/18 9:28:15
 *
 */
@RestController
public class CurrencyExchangeController {

	@Autowired
	private Environment env;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		ExchangeValue ex = new ExchangeValue(1000L, from, to, BigDecimal.valueOf(65));
		ex.setPort(Integer.parseInt(env.getProperty("local.server.port")));

		return ex;
	}
}
