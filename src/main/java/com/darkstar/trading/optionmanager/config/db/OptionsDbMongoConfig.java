package com.darkstar.trading.optionmanager.config.db;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.convert.CustomConversions;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.darkstar.trading.optionmanager.db.ZonedDateTimeReadConverter;
import com.darkstar.trading.optionmanager.db.ZonedDateTimeWriteConverter;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
@EnableMongoRepositories(basePackages="com.darkstar.trading.optionmanager.db")
public class OptionsDbMongoConfig extends AbstractMongoConfiguration {

	private final List<Converter<?,?>> converters = new ArrayList<Converter<?,?>>();
	
	@Override
	protected String getDatabaseName() {

		return "OptionsDB";
	}
	
	@Override
	public Mongo mongo() throws Exception {
	
		return new MongoClient();
	}
	
	@Override
	public CustomConversions customConversions() {
		
		converters.add(new ZonedDateTimeReadConverter());
		converters.add(new ZonedDateTimeWriteConverter());
		
		return new CustomConversions(converters);
	}
}
