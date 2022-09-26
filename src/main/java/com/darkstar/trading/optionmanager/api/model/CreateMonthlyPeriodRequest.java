package com.darkstar.trading.optionmanager.api.model;

public class CreateMonthlyPeriodRequest {

	private Integer month;
	private Integer year;
	private String name;


	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
