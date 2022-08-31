package com.UdeA.Ciclo3.controller;

import com.UdeA.Ciclo3.modelos.Empresa;
import com.UdeA.Ciclo3.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class ControllerFull {
    @Autowired // injectar otra dependencia
    EmpresaService empresaService;

    // cuando se llame a cualquiera de  los dos recursos se ejecuta ese metodo
    @GetMapping({"/","/VerEmpresas"})// / es la página de inicio
    public String viewEmpresas(Model model, @ModelAttribute("mensaje") String mensaje){ // se  ingresa cualquier tipo de datos tipo modelo
        List<Empresa> listaEmpresas=empresaService.getAllEmpresas();// se obtienen todas las empresas
        model.addAttribute("emplist",listaEmpresas);
        model.addAttribute("mensaje",mensaje);
        return "verEmpresas"; //Llamamos al HTML
    }



}
