package com.vinni.principal;



import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vinni.servicios.SOAPImplementacion;

import jakarta.xml.ws.Endpoint;

@SpringBootApplication
public class ServiciosApplication {

	public static void main(String[] args) {
		//SpringApplication.run(ServiciosApplication.class, args);
		System.out.println("Iniciando el servicio");
		String address="http://0.0.0.0:8081/";
        Endpoint.publish(address, new SOAPImplementacion());
	}

}

