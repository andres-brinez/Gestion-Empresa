package com.UdeA.Ciclo3;

import com.UdeA.Ciclo3.modelos.Empresa;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication (exclude ={SecurityAutoConfiguration.class}) // exclueye la configuración inicial de seguridad para que  no se  pida   usuario ni contraseña de inicio

public class Ciclo3Application {

	public static void main(String[] args) {
		SpringApplication.run(Ciclo3Application.class, args);
		System.out.println("hola mundo ");
	}

}
