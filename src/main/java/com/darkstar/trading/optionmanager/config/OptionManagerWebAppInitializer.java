package com.darkstar.trading.optionmanager.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class OptionManagerWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		
		return new Class<?> [] {RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?> [] {WebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {

		return new String[] { "/" };
	}

}
