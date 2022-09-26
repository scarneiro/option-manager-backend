package com.darkstar.trading.optionmanager.db;

import java.time.ZonedDateTime;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class ZonedDateTimeWriteConverter implements Converter<ZonedDateTime, Date> {

	@Override
	public Date convert(ZonedDateTime source) {
		
		return Date.from(source.toInstant());
	}
}
