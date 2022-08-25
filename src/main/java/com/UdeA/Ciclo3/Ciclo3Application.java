package com.UdeA.Ciclo3;

import com.UdeA.Ciclo3.modelos.Empresa;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController // controller
@SpringBootApplication (exclude ={SecurityAutoConfiguration.class}) // exclueye la configuración inicial de seguridad para que  no se  pida   usuario ni contraseña de inicio

public class Ciclo3Application {

	//mapeo, ejecuta una función o código  cuando se llame al recurso
	 @GetMapping("/mapeo") // cuando se llame el recurso /mapeo
	 public  String ejemploMapeo (){ // se ejecuta esta función
		return "esto es  un ejemplo de mapeo";
	 }

	@GetMapping("/test")
	public  String test (){
		 Empresa empresa1 = new Empresa("Empresa Margarita","Cra 3 *13-10 B las ferias","3103259326","123123");
		 return "El nombre de  la empresa es " + empresa1.getNombre();
	}

	public static void main(String[] args) {
		SpringApplication.run(Ciclo3Application.class, args);
		System.out.println("hola mundo ");
	}

}
