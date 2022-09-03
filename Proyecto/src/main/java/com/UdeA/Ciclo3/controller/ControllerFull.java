package com.UdeA.Ciclo3.controller;

import com.UdeA.Ciclo3.modelos.Empresa;
import com.UdeA.Ciclo3.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ControllerFull {
    @Autowired // injectar otra dependencia
    EmpresaService empresaService;

    @GetMapping({"/","/VerEmpresas"})// (/) es la página de inicio (home)
    // cuando se llame a cualquiera de  los dos recursos se ejecuta ese metodo
    public String viewEmpresas(Model model, @ModelAttribute("mensaje") String mensaje){ // se  ingresa cualquier tipo de datos tipo modelo
        List<Empresa> listaEmpresas=empresaService.getAllEmpresas();// se obtienen todas las empresas
        model.addAttribute("emplist",listaEmpresas); // el modelo emplist nos alimenta la tabla en html porque contiene todas las tablas
        model.addAttribute("mensaje",mensaje);
        return "VerEmpresas"; //Llamamos al HTML
    }

    @GetMapping("/AgregarEmpresa")
    public String nuevaEmpresa(Model model){
        Empresa emp= new Empresa();
        model.addAttribute("emp",emp);
        return  "AgregarEmpresa";
    }

    // REDIRECCIONAR- metodo post
    @PostMapping("/GuardarEmpresa")
    public String guardarEmpresa(Empresa emp, RedirectAttributes redirectAttributes){

        if(empresaService.saveOrUpdateEmpresa(emp)==true) {
            //creó la empresa
            // redirreciona la página
            return "redirect:/VerEmpresas";
        }
        return "redirect:/AgregarEmpresa";
    }

    @GetMapping("/EditarEmpresa/{id}")
    // @PathVariable | que es tipo de una ruta
    public String EditarEmpresa(Model model, @PathVariable Integer id) {
        //trae la empresa por el id
        Empresa emp= empresaService.getEmpresaById(id);
        model.addAttribute("emp",emp);

        return "EditarEmpresa";

    }

    @PostMapping("/ActualizarEmpresa")
    public String ActualizarEmpresa(Empresa emp ) {

        if(empresaService.saveOrUpdateEmpresa(emp)==true) {
            //actualizó la empresa
            // redirreciona la página
            return "redirect:/VerEmpresas";
        }
        return "redirect:/EditarEmpresa";

    }

    @GetMapping("/EliminarEmpresa/{id}")
    // @PathVariable indica se va a recibir un parametro por una ruta a web
    public String EliminarEmpresa(@PathVariable Integer id) {
        if (empresaService.deleteEmpresa(id)) {
            // si lo eliminar
            // redirreciona la página
            return "redirect:/VerEmpresas";
        }
        // redirreciona la página
        return "redirect:/VerEmpresas";
    }





}
