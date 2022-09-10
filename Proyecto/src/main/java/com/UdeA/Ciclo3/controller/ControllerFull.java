package com.UdeA.Ciclo3.controller;

import com.UdeA.Ciclo3.modelos.Empleado;
import com.UdeA.Ciclo3.modelos.Empresa;
import com.UdeA.Ciclo3.modelos.MovimientoDinero;
import com.UdeA.Ciclo3.service.EmpleadoService;
import com.UdeA.Ciclo3.service.EmpresaService;
import com.UdeA.Ciclo3.service.MovimientosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
// controller devuelve  un template para una ruta
public class ControllerFull {
    @Autowired  //Conectamos esta clase con el servicio
    EmpresaService empresaService;//Creamos un objeto tipo EmpresaService para poder usar los metodos que dicha clase hereda
    @Autowired
    EmpleadoService empleadoService;
    @Autowired
    MovimientosService movimientosService;
    // EMPRESAS

    @GetMapping({"/","Login"})
    public String  login (){
        return "Login";
    }

    @GetMapping({"/Register"})
    public String  Register (){
        return "Register";
    }


    @GetMapping({"/VerEmpresas"})// (/) es la página de inicio (home)
    // cuando se llame a cualquiera de  los dos recursos se ejecuta ese metodo
    //  @ModelAttribute("mensaje") indica que va a recibir un mensaje del un objeto Modelo (Model) que se guarda como  mensaje
    public String viewEmpresas( Model model, @ModelAttribute("mensaje") String mensaje){ // se  ingresa cualquier tipo de datos tipo modelo
        List<Empresa> listaEmpresas=empresaService.getAllEmpresas();// se obtienen todas las empresas
        model.addAttribute("emplist",listaEmpresas); // el modelo emplist nos alimenta la tabla en html porque contiene todas las tablas
        model.addAttribute("mensaje",mensaje); // añade el mensaje al modelo para poder visualizarlo en html
        return "Empresa/VerEmpresas"; //redirect a la página
    }

    @GetMapping("/AgregarEmpresa")
    public String nuevaEmpresa(Model model,@ModelAttribute("mensaje") String mensaje){
        Empresa emp= new Empresa();
        model.addAttribute("emp",emp);
        model.addAttribute("mensaje",mensaje);
        return  "Empresa/AgregarEmpresa";
    }

    // REDIRECCIONAR- a un servicio (mapping) y no a una pagina html
    @PostMapping("/GuardarEmpresa")
    // redirreciona un servicio y no un templete
    public String guardarEmpresa(Empresa emp, RedirectAttributes redirectAttributes){

        if(empresaService.saveOrUpdateEmpresa(emp)) {
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
        return "Empresa/EditarEmpresa";

    }

    @PostMapping("/ActualizarEmpresa")
    public String ActualizarEmpresa(Empresa emp, RedirectAttributes redirectAttributes ) {

        if(empresaService.saveOrUpdateEmpresa(emp)) {
            //actualizó la empresa
            redirectAttributes.addFlashAttribute("mensaje","updateOk");
            // redirreciona la página
            return "redirect:/VerEmpresas";
        }
        // cuando hay un error
        redirectAttributes.addFlashAttribute("mensaje","updateError");
        return "redirect:/EditarEmpresa/"+emp.getId();

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

    // EMPLEADOS
    // Model atributte está explicado arriba

    // Ver todos los empleados
    @GetMapping ("/VerEmpleados")
    public String viewEmpleados(Model model, @ModelAttribute("mensaje") String mensaje){
        List<Empleado> listaEmpleados=empleadoService.getAllEmpleados(); // lista de empleados donde seran guardados todos
        model.addAttribute("emplelist",listaEmpleados); // guarda en un objeto (modelo ) los empleados  para  poder usarlos con thimleaf en html
        model.addAttribute("mensaje",mensaje);// guarda el mensaje para poder usarlo en html
        return "Empleado/VerEmpleados"; //Llamamos al HTML
    }

    @GetMapping("/AgregarEmpleado")
    public String nuevoEmpleado(Model model, @ModelAttribute("mensaje") String mensaje){
        Empleado empl= new Empleado();
        model.addAttribute("empl",empl);
        model.addAttribute("mensaje",mensaje);
        // lista de las empresas  para mostrar en el html
        List<Empresa> listaEmpresas= empresaService.getAllEmpresas();
        model.addAttribute("emprelist",listaEmpresas);
        return "Empleado/AgregarEmpleado"; //Llamar HTML
    }

    @PostMapping("/GuardarEmpleado")
    public String guardarEmpleado(Empleado empl, RedirectAttributes redirectAttributes){
        // si se guardó el empleado
        if(empleadoService.saveOrUpdateEmpleado(empl)){
            // mensaje a mostrar em html
            redirectAttributes.addFlashAttribute("mensaje","saveOK");
            return "redirect:/VerEmpleados";
        }
        // si no guardó el empleado
        // mensaje a mostrar en el html
        redirectAttributes.addFlashAttribute("mensaje","saveError");
        return "redirect:/AgregarEmpleado";
    }

    @GetMapping("/EditarEmpleado/{id}")
    // @PathVariable Integer id, ricebe por  la ruta una variable de  tipo integer llamada id
    public String editarEmpleado(Model model, @PathVariable Integer id, @ModelAttribute("mensaje") String mensaje){
        Empleado empl=empleadoService.getEmpleadoById(id).get(); // obtener el empleado
        //Creamos un atributo para el modelo, que se llame igualmente empl y es el que ira al html para llenar o alimentar campos
        model.addAttribute("empl",empl);
        model.addAttribute("mensaje", mensaje);
        // lista de las empresas  para mostrar en el html
        List<Empresa> listaEmpresas= empresaService.getAllEmpresas();
        model.addAttribute("emprelist",listaEmpresas);
        return "Empleado/EditarEmpleado";
    }

    @PostMapping("/ActualizarEmpleado")
    public String updateEmpleado(@ModelAttribute("empl") Empleado empl, RedirectAttributes redirectAttributes){
        if(empleadoService.saveOrUpdateEmpleado(empl)){
            redirectAttributes.addFlashAttribute("mensaje","updateOK");
            return "redirect:/VerEmpleados";
        }
        redirectAttributes.addFlashAttribute("mensaje","updateError");
        return "redirect:/EditarEmpleado/"+empl.getId();

    }

    @GetMapping("/EliminarEmpleado/{id}")
    public String eliminarEmpleado(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        if (empleadoService.deleteEmpleado(id)){
            redirectAttributes.addFlashAttribute("mensaje","deleteOK");
            return "redirect:/VerEmpleados";
        }
        // si no se eliminó
        redirectAttributes.addFlashAttribute("mensaje", "deleteError");
        return "redirect:/VerEmpleados";
    }

    //Filtrar los empleados por empresa
    @GetMapping("/Empresa/{id}/Empleados")
    public String verEmpleadosPorEmpresa(@PathVariable("id") Integer id, Model model){
        List<Empleado> listaEmpleados = empleadoService.obtenerPorEmpresa(id); // lista de empleados
        model.addAttribute("emplelist",listaEmpleados); // envía en un objeto la lista de todos los empleados de una empresa especirficada en el id
        return "Empleado/VerEmpleados"; //Llamamos al html con el emplelist de los empleados filtrados
    }


    //MOVIMIENTOS

    // Controlador que nos lleva al template donde veremos todos los movimientos
    @GetMapping ("/VerMovimientos")
    public String viewMovimientos(Model model, @ModelAttribute("mensaje") String mensaje){
        List<MovimientoDinero> listaMovimientos= movimientosService.getAllMovimientos();
        model.addAttribute("movlist",listaMovimientos);
        model.addAttribute("mensaje",mensaje);
        Long sumaMonto= movimientosService.obtenerSumaMontos();
        model.addAttribute("sumaMontos",sumaMonto); // se manda la suma de todos los montos a la plantilla
        return "Movimiento/VerMovimientos"; //Llamamos al HTML
    }

    //Controlador que nos lleva al template donde podremos crear un nuevo movimiento
    @GetMapping("/AgregarMovimiento")
    public String nuevoMovimiento(Model model, @ModelAttribute("mensaje") String mensaje){
        MovimientoDinero movimiento= new MovimientoDinero();
        model.addAttribute("mov",movimiento);
        model.addAttribute("mensaje",mensaje);
        // guarda todos los empleados en una lista para mostrarlos en el html
        List<Empleado> listaEmpleados= empleadoService.getAllEmpleados();
        model.addAttribute("emplelist",listaEmpleados);
        return "Movimiento/AgregarMovimiento"; //Llamar HTML
    }

    @PostMapping("/GuardarMovimiento")
    public String guardarMovimiento(MovimientoDinero mov, RedirectAttributes redirectAttributes){
        if(movimientosService.saveOrUpdateMovimiento(mov)){
            // si se guarda el movimiento
            redirectAttributes.addFlashAttribute("mensaje","saveOK");
            return "redirect:/VerMovimientos";
        }
        // si no se guarda el movimiento
        redirectAttributes.addFlashAttribute("mensaje","saveError");
        return "redirect:/AgregarMovimiento";
    }

    @GetMapping("/EditarMovimiento/{id}")
    public String editarMovimento(Model model, @PathVariable Integer id, @ModelAttribute("mensaje") String mensaje){
        MovimientoDinero mov=movimientosService.getMovimientoById(id);
        //Creamos un atributo para el modelo, que se llame igualmente empl y es el que ira al html para llenar o alimentar campos
        model.addAttribute("mov",mov);
        model.addAttribute("mensaje", mensaje);
        // lista de empleados para mostrar en el html
        List<Empleado> listaEmpleados= empleadoService.getAllEmpleados();
        model.addAttribute("emplelist",listaEmpleados);
        return "Movimiento/EditarMovimiento";
    }

    @PostMapping("/ActualizarMovimiento")
    public String updateMovimiento(@ModelAttribute("mov") MovimientoDinero mov, RedirectAttributes redirectAttributes){
        if(movimientosService.saveOrUpdateMovimiento(mov)){

            redirectAttributes.addFlashAttribute("mensaje","updateOK");
            return "redirect:/VerMovimientos";
        }
        redirectAttributes.addFlashAttribute("mensaje","updateError");
        return "redirect:/EditarMovimiemto/"+mov.getId();

    }

    @GetMapping("/EliminarMovimiento/{id}")
    public String eliminarMovimiento(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        if (movimientosService.deleteMovimiento(id)){
            redirectAttributes.addFlashAttribute("mensaje","deleteOK");
            return "redirect:/VerMovimientos";
        }
        redirectAttributes.addFlashAttribute("mensaje", "deleteError");
        return "redirect:/VerMovimientos";
    }

    @GetMapping("/Empleado/{id}/Movimientos") //Filtro de movimientos por empleados
    public String movimientosPorEmpleado(@PathVariable("id")Integer id, Model model){
        List<MovimientoDinero> movlist = movimientosService.obtenerPorEmpleado(id);
        model.addAttribute("movlist",movlist);
        Long sumaMonto= movimientosService.MontosPorEmpleado(id);
        model.addAttribute("sumaMontos",sumaMonto); // se manda la suma de todos los montos a la plantilla
        return "Movimiento/VerMovimientos"; //Llamamos al HTML
    }

    //Filtro de movimientos por empresa
    @GetMapping("/Empresa/{id}/Movimientos")
    public String movimientosPorEmpresa(@PathVariable("id")Integer id, Model model){
        List<MovimientoDinero> movlist = movimientosService.obtenerPorEmpresa(id);
        model.addAttribute("movlist",movlist);
        Long sumaMonto= movimientosService.MontosPorEmpresa(id);
        model.addAttribute("sumaMontos",sumaMonto); // se manda la suma de todos los montos a la plantilla
        return "Movimiento/VerMovimientos"; //Llamamos al HTML
    }



    // TODO consultar movimietos  por emepleados , clase minuto 24
    // TODO  consultar movimientos  por empresa clase 16 minuto 24
    // TODO sumar la cantidad de  movimientos por empleado Y EMPRESA






}
