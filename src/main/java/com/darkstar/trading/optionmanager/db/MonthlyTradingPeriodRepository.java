package com.darkstar.trading.optionmanager.db;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.darkstar.trading.optionmanager.domain.MonthlyTradingPeriod;

public interface MonthlyTradingPeriodRepository extends MongoRepository<MonthlyTradingPeriod, String> {

	public MonthlyTradingPeriod findMonthlyTradingPeriodByStatusAndTypeAndMonthAndYear(String status, String type, Integer month, Integer year);
	public List<MonthlyTradingPeriod> findMonthlyTradingPeriodByStatusAndType(String status, String type);
	public List<MonthlyTradingPeriod> findMonthlyTradingPeriodByStatus(String status);
}
