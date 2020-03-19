package com.star.sud.model;

import java.io.Serializable;

public class LimitConfiguration implements Serializable {

	// Static Attributes
	/////////////////////
	private static final long serialVersionUID = 5763457807605790943L;

	// Attributes
	//////////////////
	private int maximum;
	private int minimum;

	// Constructors
	///////////////////
	public LimitConfiguration() {
		super();
	}

	/**
	 * @param minimum
	 * @param maximum
	 */
	public LimitConfiguration(int maximum, int minimum) {
		super();
		this.maximum = maximum;
		this.minimum = minimum;
	}

	// Properties
	/////////////////
	public int getMaximum() {
		return maximum;
	}

	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}

	public int getMinimum() {
		return minimum;
	}

	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}

}
