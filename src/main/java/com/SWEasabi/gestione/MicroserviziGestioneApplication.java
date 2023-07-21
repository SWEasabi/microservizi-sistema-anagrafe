package com.SWEasabi.gestione;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.SWEasabi.gestione.repositories")
@EntityScan("com.SWEasabi.gestione.entities")
public class MicroserviziGestioneApplication{
	
	public static void main(String[] args) {
		SpringApplication.run(MicroserviziGestioneApplication.class, args);
	}

}
