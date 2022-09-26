package com.darkstar.trading.optionmanager.api;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.darkstar.trading.optionmanager.api.model.CreateMonthlyPeriodRequest;
import com.darkstar.trading.optionmanager.api.model.CreateMonthlyPositionRequest;
import com.darkstar.trading.optionmanager.api.model.OptionPositionDTO;
import com.darkstar.trading.optionmanager.api.model.OptionTradingPeriodDTO;
import com.darkstar.trading.optionmanager.db.MonthlyTradingPeriodRepository;
import com.darkstar.trading.optionmanager.domain.FullOptionPosition;
import com.darkstar.trading.optionmanager.domain.MonthlyTradingPeriod;

@RestController
@RequestMapping("/option-positions")
@CrossOrigin(origins="http://localhost:4200")
public class OptionPositionController {

	private MonthlyTradingPeriodRepository repository;
	
	@Autowired
	public OptionPositionController(MonthlyTradingPeriodRepository repository) {
		
		this.repository = repository;
	}
	
	@GetMapping
	public List<OptionTradingPeriodDTO> getMonthlyActivePeriods() {
		
		List<OptionTradingPeriodDTO> periods = new ArrayList<OptionTradingPeriodDTO>();
		
		for (MonthlyTradingPeriod period: repository.findMonthlyTradingPeriodByStatus("A")) {
	
			periods.add(new OptionTradingPeriodDTO(period));
		}
		
		return periods;
	}

	@PostMapping
	public OptionTradingPeriodDTO createMonthlyPeriod(@RequestBody CreateMonthlyPeriodRequest periodRequest) {
	
		MonthlyTradingPeriod tradingPeriod = new MonthlyTradingPeriod();
		tradingPeriod.setMonth(periodRequest.getMonth());
		tradingPeriod.setYear(periodRequest.getYear());
		tradingPeriod.setName(periodRequest.getName());
		tradingPeriod.setStatus("A");
		tradingPeriod.setType("M");
		
		return new OptionTradingPeriodDTO(repository.save(tradingPeriod));
	}
	
	@PutMapping
	public OptionTradingPeriodDTO updateMonthlyPeriod(@RequestBody CreateMonthlyPeriodRequest periodRequest) {
	
		MonthlyTradingPeriod period = 
				repository.findMonthlyTradingPeriodByStatusAndTypeAndMonthAndYear("A", "M", periodRequest.getMonth(), periodRequest.getYear());
		
		if (period != null) {
			period.setMonth(periodRequest.getMonth());
			period.setYear(periodRequest.getYear());
			period.setName(periodRequest.getName());
			
			return new OptionTradingPeriodDTO(repository.save(period));
		}
		
		return null;
	}
	
	@GetMapping("/monthlies/{year}/{month}")
	public OptionTradingPeriodDTO getMonthlyActivePeriod(
			@PathVariable Integer year,
			@PathVariable Integer month) {
		
		return new OptionTradingPeriodDTO(
				repository.findMonthlyTradingPeriodByStatusAndTypeAndMonthAndYear(
						"A", 
						"M", 
						month, 
						year));
	}

	@PostMapping("/monthlies/{year}/{month}")
	public OptionPositionDTO createMonthlyPosition(@RequestBody CreateMonthlyPositionRequest request) {
		
		MonthlyTradingPeriod period = repository.findMonthlyTradingPeriodByStatusAndTypeAndMonthAndYear("A", "M", request.getPeriodMonth(), request.getPeriodYear());
		
		FullOptionPosition position = new FullOptionPosition(
				ZonedDateTime.now(),
				request.getUnderlying(),
				request.getOpeningPrice(),
				request.getQuantity(),
				request.getSetupName(),
				request.getInitialBuyingPower(),
				request.getTarget(),
				request.getMaxLoss());
		
		period.addPosition(position);
		repository.save(period);
		
		return new OptionPositionDTO(position);
	}

	@PutMapping("/monthlies/{year}/{month}")
	public OptionPositionDTO updateOptionPosition(
			@PathVariable Integer year,
			@PathVariable Integer month,
			@RequestBody OptionPositionDTO position) {
		
		MonthlyTradingPeriod period = 
				repository.findMonthlyTradingPeriodByStatusAndTypeAndMonthAndYear(
						"A", 
						"M", 
						month, 
						year);
		
		FullOptionPosition currentPosition = period.findPositionByDate(position.getOpenDate());
		
		currentPosition.setClosePrice(position.getClosePrice());
		currentPosition.setInitialBuyingPower(position.getInitialBuyingPower());
		currentPosition.setMaxLoss(position.getMaxLoss());
		currentPosition.setNetPnL(position.getNetPnL());
		currentPosition.setQuantity(position.getQuantity());
		currentPosition.setSetupName(position.getSetupName());
		currentPosition.setStatus(position.getStatus());
		currentPosition.setTarget(position.getTarget());
		currentPosition.setUnderlying(position.getUnderlying());
		currentPosition.setOpeningPrice(position.getOpeningPrice());
		
		repository.save(period);
		
		return new OptionPositionDTO(currentPosition);
	}
	
	@DeleteMapping("/monthlies/{year}/{month}")
	public void deletePeriod(
			@PathVariable Integer year,
			@PathVariable Integer month) {
		
		MonthlyTradingPeriod period = repository
				.findMonthlyTradingPeriodByStatusAndTypeAndMonthAndYear("A", "M", month, year);
		
		repository.delete(period);
	}
}
