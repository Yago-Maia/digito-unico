package com.digito.unico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class DigitoUnicoApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(DigitoUnicoApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DigitoUnicoApplication.class);
	}

}
