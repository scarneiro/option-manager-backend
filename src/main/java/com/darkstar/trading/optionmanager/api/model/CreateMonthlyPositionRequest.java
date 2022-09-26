package com.darkstar.trading.optionmanager.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateMonthlyPositionRequest {

	private Integer periodMonth;
	private Integer periodYear;
	private String underlying;
	private Double openingPrice;
	private Integer quantity;
	private String setupName;
	private Double initialBuyingPower;
	private Double target;
	private Double maxLoss;
	

	public Integer getPeriodMonth() {
		return periodMonth;
	}

	public void setPeriodMonth(Integer periodMonth) {
		this.periodMonth = periodMonth;
	}

	public Integer getPeriodYear() {
		return periodYear;
	}

	public void setPeriodYear(Integer periodYear) {
		this.periodYear = periodYear;
	}

	public String getUnderlying() {
		return underlying;
	}
	
	public void setUnderlying(String underlying) {
		this.underlying = underlying;
	}
	
	@JsonProperty("opening_price")
	public Double getOpeningPrice() {
		return openingPrice;
	}
	
	public void setOpeningPrice(Double openingPrice) {
		this.openingPrice = openingPrice;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	@JsonProperty("setup_name")
	public String getSetupName() {
		return setupName;
	}
	
	public void setSetupName(String setupName) {
		this.setupName = setupName;
	}
	
	@JsonProperty("initial_buying_power")
	public Double getInitialBuyingPower() {
		return initialBuyingPower;
	}
	
	public void setInitialBuyingPower(Double initialBuyingPower) {
		this.initialBuyingPower = initialBuyingPower;
	}
	
	public Double getTarget() {
		return target;
	}
	
	public void setTarget(Double target) {
		this.target = target;
	}
	
	@JsonProperty("max_loss")
	public Double getMaxLoss() {
		return maxLoss;
	}
	
	public void setMaxLoss(Double maxLoss) {
		this.maxLoss = maxLoss;
	}
}
