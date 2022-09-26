package com.darkstar.trading.optionmanager.api.model;

import java.util.ArrayList;
import java.util.List;

import com.darkstar.trading.optionmanager.domain.FullOptionPosition;
import com.darkstar.trading.optionmanager.domain.MonthlyTradingPeriod;

public class OptionTradingPeriodDTO {

	private String name;
	private String type;
	private List<OptionPositionDTO> positions;
	private String status;
	
	public OptionTradingPeriodDTO() {	}
	
	public OptionTradingPeriodDTO(MonthlyTradingPeriod period) {

		this.name = period.getName();
		this.type = period.getType();
		
		this.positions = new ArrayList<OptionPositionDTO>();
		
		for (FullOptionPosition position: period.getPositions()) {
			this.positions.add(new OptionPositionDTO(position));
		}
		
		this.status = period.getStatus();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public List<OptionPositionDTO> getPositions() {
		return positions;
	}
	
	public void setPositions(List<OptionPositionDTO> positions) {
		this.positions = positions;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
}
