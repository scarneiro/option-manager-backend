package com.darkstar.trading.optionmanager.api.model;

import java.time.ZonedDateTime;

import com.darkstar.trading.optionmanager.domain.FullOptionPosition;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OptionPositionDTO {

	private ZonedDateTime openDate;
	private String underlying;
	private Double openingPrice;
	private Integer quantity;
	private String status;
	private Double closePrice;
	private String setupName;
	private Double initialBuyingPower;
	private Double target;
	private Double maxLoss;
	private Double netPnL;
	
	public OptionPositionDTO() {

	}
	
	
	public OptionPositionDTO(FullOptionPosition domainPosition) {
					
		this.openDate = domainPosition.getOpenDate();
		this.underlying = domainPosition.getUnderlying();
		this.openingPrice = domainPosition.getOpeningPrice();
		this.quantity = domainPosition.getQuantity();
		this.status = domainPosition.getStatus();
		this.closePrice = domainPosition.getClosePrice();
		this.setupName = domainPosition.getSetupName();
		this.initialBuyingPower = domainPosition.getInitialBuyingPower();
		this.target = domainPosition.getTarget();
		this.maxLoss = domainPosition.getMaxLoss();
		this.netPnL = domainPosition.getNetPnL();
	}
	
	@JsonProperty("open_date")
	public ZonedDateTime getOpenDate() {
		return openDate;
	}

	public void setOpenDate(ZonedDateTime openDate) {
		this.openDate = openDate;
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
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	@JsonProperty("close_price")
	public Double getClosePrice() {
		return closePrice;
	}
	
	public void setClosePrice(Double closePrice) {
		this.closePrice = closePrice;
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
	
	@JsonProperty("net_pnl")
	public Double getNetPnL() {
		return netPnL;
	}
	
	public void setNetPnL(Double netPnL) {
		this.netPnL = netPnL;
	}
}
