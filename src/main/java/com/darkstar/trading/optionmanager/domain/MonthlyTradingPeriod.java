package com.darkstar.trading.optionmanager.domain;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="MonthlyTradingPeriod")
public class MonthlyTradingPeriod {

	@Id
	private String id;
	private String name;
	private String type;
	private Integer month;
	private Integer year;
	private List<FullOptionPosition> positions = new ArrayList<FullOptionPosition>();
	private String status;
	
	public String getId() {
		return id;
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
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public List<FullOptionPosition> getPositions() {
		return positions;
	}
	
	public void setPositions(List<FullOptionPosition> positions) {
		this.positions = positions;
	}
	
	
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

	public void addPosition(FullOptionPosition position) {
		
		this.positions.add(position);
	}
	
	public FullOptionPosition findPositionByDate(ZonedDateTime positionDate) {
		
		for (FullOptionPosition position: positions) {
			
			if (position.getOpenDate().isEqual(positionDate)) {
				return position;
			}
		}
		
		return null;
	}
}
