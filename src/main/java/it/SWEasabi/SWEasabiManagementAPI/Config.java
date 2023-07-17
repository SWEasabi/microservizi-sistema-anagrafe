package it.SWEasabi.SWEasabiManagementAPI;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import it.SWEasabi.management.Context;
import it.SWEasabi.management.services.AccessKeyService;
import it.SWEasabi.management.services.DTOBuilderService;
import it.SWEasabi.management.services.LocalAccessKeyService;
import it.SWEasabi.management.services.LocalDTOBuilderService;

@Configuration
public class Config {

	@Bean
	public Context getCore() {
		return new Context(new LocalAccessKeyService(),new LocalDTOBuilderService());
	}
}
