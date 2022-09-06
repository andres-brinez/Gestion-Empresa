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
// controller devuelve  un template para una ruta
public class ControllerFull {
    @Autowired // injectar otra dependencia
    EmpresaService empresaService;

    @GetMapping({"/","/VerEmpresas"})// (/) es la página de inicio (home)
    // cuando se llame a cualquiera de  los dos recursos se ejecuta ese metodo
    //  @ModelAttribute("mensaje") indica que va a recibir un mensaje del un objeto Modelo (Model) que se guarda como  mensaje
    public String viewEmpresas( Model model, @ModelAttribute("mensaje") String mensaje){ // se  ingresa cualquier tipo de datos tipo modelo
        List<Empresa> listaEmpresas=empresaService.getAllEmpresas();// se obtienen todas las empresas
        model.addAttribute("emplist",listaEmpresas); // el modelo emplist nos alimenta la tabla en html porque contiene todas las tablas
        model.addAttribute("mensaje",mensaje); // añade el mensaje al modelo para poder visualizarlo en html
        return "VerEmpresas"; //redirect a la página
    }

    @GetMapping("/AgregarEmpresa")
    public String nuevaEmpresa(Model model,@ModelAttribute("mensaje") String mensaje){
        Empresa emp= new Empresa();
        model.addAttribute("emp",emp);
        model.addAttribute("mensaje",mensaje);
        return  "AgregarEmpresa";
    }

    // REDIRECCIONAR- metodo post
    @PostMapping("/GuardarEmpresa")
    // redirreciona un servicio y no un templete
    public String guardarEmpresa(Empresa emp, RedirectAttributes redirectAttributes){

        if(empresaService.saveOrUpdateEmpresa(emp)==true) {
            //creó la empresa
            redirectAttributes.addFlashAttribute("mensaje","saveOk"); // se crea un mensaje y se envia a la vista
            // redirreciona la página
            return "redirect:/VerEmpresas";
        }
        // cuando hay un error
        redirectAttributes.addFlashAttribute("mensaje","saveError");
        return "redirect:/AgregarEmpresa";
    }

    @GetMapping("/EditarEmpresa/{id}")
    // @PathVariable | que el id es el que viene en la ruta
    public String EditarEmpresa(Model model, @PathVariable Integer id,@ModelAttribute("mensaje") String mensaje) {
        //trae la empresa por el id
        Empresa emp= empresaService.getEmpresaById(id);
        model.addAttribute("emp",emp);
        model.addAttribute("mensaje",mensaje);
        return "EditarEmpresa";

    }

    @PostMapping("/ActualizarEmpresa")
    public String ActualizarEmpresa(Empresa emp, RedirectAttributes redirectAttributes ) {

        if(empresaService.saveOrUpdateEmpresa(emp)==true) {
            //actualizó la empresa
            redirectAttributes.addFlashAttribute("mensaje","updateOk");
            // redirreciona la página
            return "redirect:/VerEmpresas";
        }
        // cuando hay un error
        redirectAttributes.addFlashAttribute("mensaje","updateError");
        return "redirect:/EditarEmpresa";

    }

    @GetMapping("/EliminarEmpresa/{id}")
    // @PathVariable indica se va a recibir un parametro por una ruta a web
    public String EliminarEmpresa(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        if (empresaService.deleteEmpresa(id)) {
            // si lo elimina
            redirectAttributes.addFlashAttribute("mensaje","deleteOk");
            // redirreciona la página
            return "redirect:/VerEmpresas";
        }
        // redirreciona la página si hay error
        redirectAttributes.addFlashAttribute("mensaje","deleteError");
        return "redirect:/VerEmpresas";
    }

    // TODO ver todos  los empleados de  una empresa en una table , se debe seleccinar la empresa y mostrar los empleados- clase 13 1:10
    // TODO mostrar todos  los  usuarios (empleados) registrados clase 13, seria igual al servicio de empresas pero con empleados
    // TODO consultar movimietos  por emepleados , clase minuto 24
    // TODO  consultar movimientos  por empresa clase 16 minuto 24
    // TODO  se  puede hacer filtros  por fechas , tipo de empleados , se hace con la sentencia sql





}
