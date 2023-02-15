package com.example.PruebaTecnicaARVision;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * Prueba técnica sobre desarrollo de aplicación web Java utilizando Spring Boot, PostgreSQL, Hibernate y Docker Compose
 * NOTA: Para iniciar el proyecto escriba en la terminal "mvn spring-boot:run"
 * NOTA: Para lanzar el Docker: "cd src/main/docker" + "docker-compose up"
 */
@SpringBootApplication
public class PruebaTecnicaArVisionApplication {

	public static void main(String[] args) {
		SpringApplication.run(PruebaTecnicaArVisionApplication.class, args);
	}

}
