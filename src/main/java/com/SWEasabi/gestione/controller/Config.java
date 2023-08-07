package com.SWEasabi.gestione.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.SWEasabi.gestione.core.CoreGestione;
import com.SWEasabi.gestione.kernel.AreaManager;
import com.SWEasabi.gestione.kernel.LampManager;
import com.SWEasabi.gestione.kernel.SensorManager;
import com.SWEasabi.gestione.services.JsonBuilderService;

@Configuration
public class Config {

	@Bean
	public CoreGestione getCore() {
		return new CoreGestione();
	}
	
	@Bean
	public LampManager getLampManager() {
		return new LampManager();
	}
	
	@Bean
	public SensorManager getSensorManager() {
		return new SensorManager();
	}
	
	@Bean
	public AreaManager getAreaManager() {
		return new AreaManager();
	}
	
	@Bean
	public JsonBuilderService getJsonBuilder() {
		return new JsonBuilderService();
	}
}
