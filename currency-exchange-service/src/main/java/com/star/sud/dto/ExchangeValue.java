package com.star.sud.dto;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_EXCHANGE_VALUES")
public class ExchangeValue {

	// properties
	/////////////////
	@Id
	private Long id;

	@Column(name = "CCY_FROM")
	private String from;

	@Column(name = "CCY_TO")
	private String to;

	@Column(name = "CONV_MULITPLE")
	private BigDecimal conversionMultiple;

	@Column(name = "PORT")
	private int port;

	// Constructors
	///////////////////
	public ExchangeValue() {
		super();
	}

	/**
	 * @param id
	 * @param from
	 * @param to
	 * @param conversionMultiple
	 */
	public ExchangeValue(Long id, String from, String to, BigDecimal conversionMultiple, int port) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
		this.port = port;
	}

	// Properties
	//////////////////
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}

	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

}
