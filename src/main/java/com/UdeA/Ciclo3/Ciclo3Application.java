package com.UdeA.Ciclo3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController // controller
@SpringBootApplication (exclude ={SecurityAutoConfiguration.class}) // exclueye la configuración inicial de seguridad para que  no se  pida   usuario ni contraseña de inicio

public class Ciclo3Application {

	//mapeo, ejecuta una función o código  cuando se llame al recurso
	 @GetMapping("/saludar") // cuando se llame el recurso /saludar
	 public  String saludar (){ // se ejecuta esta función
		return "Hola ciclo 3, saldremos vivos de este ciclo";
	 }


	public static void main(String[] args) {
		SpringApplication.run(Ciclo3Application.class, args);
		System.out.println("hola mundo ");
	}

}
