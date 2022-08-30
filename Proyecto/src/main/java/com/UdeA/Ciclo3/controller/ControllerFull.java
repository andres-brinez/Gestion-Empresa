package com.UdeA.Ciclo3.controller;

import com.UdeA.Ciclo3.modelos.Empresa;
import com.UdeA.Ciclo3.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller // indica que es un controlador
public class ControllerFull {
    //mapeo, ejecuta una función o código  cuando se llame al recurso

    @GetMapping("/mapeo") // cuando se llame el recurso /mapeo
    public  String ejemploMapeo ()
    { // se ejecuta esta función
        return "esto es  un ejemplo de mapeo";

    }

    @Autowired // se usa para inyectar una dependencia, es decir que se pueda usar el servicio de empresa
    EmpresaService empresaService;

    @GetMapping({"/Empresas","/VerEmpresas"}) // cuando se llame a cualquiera de  los dos recursos se ejecuta ese metodo
    public  String verEmpresas (Model model) { // se  ingresa cualquier tipo de datos tipo modelo
        List<Empresa> ListaEmpresas = empresaService.getAllEmpresas(); // se obtienen todas las empresas
        model.addAttribute("empresasList",ListaEmpresas); // se agrega la lista de empresas al modelo
        return "VerEmpresas"; // nombre del archivo html que se va a mostrar
    }
}
