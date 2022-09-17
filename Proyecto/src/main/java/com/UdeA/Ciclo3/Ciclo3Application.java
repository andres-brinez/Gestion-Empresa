package com.UdeA.Ciclo3;

import com.UdeA.Ciclo3.modelos.Empresa;
import org.hibernate.annotations.GeneratorType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


//@SpringBootApplication (exclude ={SecurityAutoConfiguration.class}) para que  no  nos  pida  autenticación al iniciar el proyecto, si debe quitar cuando se necesita hacer autenticacion
@SpringBootApplication

public class Ciclo3Application {


	public static void main(String[] args) {

		SpringApplication.run(Ciclo3Application.class, args
		);
		System.out.println("Ejecutando aplicación");
	}

}
