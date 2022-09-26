package com.darkstar.trading.optionmanager.domain;

import java.time.ZonedDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

public class FullOptionPosition {

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
	
	public FullOptionPosition() {}
	
	public FullOptionPosition(
			ZonedDateTime openDate,
			String underlying,
			Double openingPrice,
			Integer quantity,
			String setupName,
			Double initialBuyingPower,
			Double target,
			Double maxLoss) {
		
		this.openDate = openDate;
		this.underlying = underlying;
		this.openingPrice = openingPrice;
		this.quantity = quantity;
		this.setupName = setupName;
		this.initialBuyingPower = initialBuyingPower;
		this.target = target;
		this.maxLoss = maxLoss;
	}
	
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
	
	public Double getClosePrice() {
		return closePrice;
	}
	
	public void setClosePrice(Double closePrice) {
		this.closePrice = closePrice;
	}
	
	public String getSetupName() {
		return setupName;
	}
	
	public void setSetupName(String setupName) {
		this.setupName = setupName;
	}
	
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
	
	public Double getMaxLoss() {
		return maxLoss;
	}
	
	public void setMaxLoss(Double maxLoss) {
		this.maxLoss = maxLoss;
	}
	
	public Double getNetPnL() {
		return netPnL;
	}
	
	public void setNetPnL(Double netPnL) {
		this.netPnL = netPnL;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (obj == null) {
			return false;
		}
			
		if (! (obj instanceof FullOptionPosition)) {
			return false;
		}
		
		FullOptionPosition other = (FullOptionPosition) obj;
		
		if (! other.getOpenDate().isEqual(getOpenDate()) ||
				! other.getUnderlying().equals(getUnderlying())) {
			return false;
		}
		
		return true;
	}
}
