package com.star.sud.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.star.sud.dto.CurrencyConversionBean;
import com.star.sud.feignproxy.CurrencyExchangeServiceProxy;

@RestController
public class CurrencyConversionController {

	Logger log = LoggerFactory.getLogger(CurrencyConversionController.class);

	private static final String URL = "http://localhost:8000/currency-exchange/from/{from}/to/{to}";

	@Autowired
	private CurrencyExchangeServiceProxy proxy;

	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable("from") String from, @PathVariable("to") String to,
			@PathVariable("quantity") BigDecimal quantity) {

		Map<String, String> parameters = new HashMap<>();
		parameters.put("from", from);
		parameters.put("to", to);

		ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity(URL,
				CurrencyConversionBean.class, parameters);

		CurrencyConversionBean conversionBean = responseEntity.getBody();

		CurrencyConversionBean currencyConversionBean = new CurrencyConversionBean(conversionBean.getId(), from, to,
				conversionBean.getConversionMultiple(), quantity,
				conversionBean.getConversionMultiple().multiply(quantity), conversionBean.getPort());

		return currencyConversionBean;
	}

	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrencyFeign(@PathVariable("from") String from, @PathVariable("to") String to,
			@PathVariable("quantity") BigDecimal quantity) {

		CurrencyConversionBean conversionBean = proxy.convertCurrency(from, to);

		CurrencyConversionBean currencyConversionBean = new CurrencyConversionBean(conversionBean.getId(), from, to,
				conversionBean.getConversionMultiple(), quantity,
				conversionBean.getConversionMultiple().multiply(quantity), conversionBean.getPort());

		log.info("{}", currencyConversionBean);

		return currencyConversionBean;
	}

}
