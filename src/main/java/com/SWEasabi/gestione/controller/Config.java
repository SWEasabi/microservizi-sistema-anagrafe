package com.SWEasabi.gestione.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.SWEasabi.gestione.kernel.DatabaseAreaManager;
import com.SWEasabi.gestione.kernel.DatabaseLampManager;
import com.SWEasabi.gestione.kernel.DatabaseSensorManager;
import com.SWEasabi.gestione.services.JsonBuilderService;

@Configuration
public class Config {
	
	@Bean
	DatabaseLampManager getLampManager() {
		return new DatabaseLampManager();
	}
	
	@Bean
	DatabaseSensorManager getSensorManager() {
		return new DatabaseSensorManager();
	}
	
	@Bean
	DatabaseAreaManager getAreaManager() {
		return new DatabaseAreaManager();
	}
	
	@Bean
	JsonBuilderService getJsonBuilder() {
		return new JsonBuilderService();
	}
}
