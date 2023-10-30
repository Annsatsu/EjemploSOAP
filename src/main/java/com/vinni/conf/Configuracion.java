package com.vinni.conf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.vinni.servicios.SOAPImplementacion;

import jakarta.xml.ws.Endpoint;

@Configuration
@EnableJpaRepositories(basePackages = "com.vinni.repository;")

public class Configuracion {

    @Autowired
	private SOAPImplementacion vehiculoServices;

	@Bean
	public Endpoint vehiculosEndpoints() {
		Endpoint endpoints = Endpoint.publish("http://0.0.0.0:8081/", vehiculoServices);
		return endpoints;
	}
}

    