package com.UdeA.Ciclo3.service;

import com.UdeA.Ciclo3.modelos.Empleado;
import com.UdeA.Ciclo3.modelos.MovimientoDinero;
import com.UdeA.Ciclo3.repo.MovimientosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovimientosService {
    @Autowired // conectamos con el repositorio indicado abajo
    MovimientosRepository movimientosRepository;

    //Metodo que muestra todos los movimientos sin ningun filtro
    public List<MovimientoDinero> getAllMovimientos(){
        List<MovimientoDinero> movimientosList = new ArrayList<>(); // crea la lista
        movimientosRepository.findAll().forEach(movimiento -> movimientosList.add(movimiento));  //Recorremos el iterable que regresa el metodo findAll del Jpa(regresa todos los movimientos) y lo guardamos en la lista creada
        return movimientosList;
    }

    //Ver movimientos por id
    public MovimientoDinero getMovimientoById(Integer id){
        return movimientosRepository.findById(id).get();
    }

    //Guardar o actualizar elementos
    public boolean saveOrUpdateMovimiento(MovimientoDinero movimientoDinero){
        MovimientoDinero mov=movimientosRepository.save(movimientoDinero);
        // esto es para confirmar que se guardo el movimiento
        if (movimientosRepository.findById(mov.getId())!=null){
            // si el movimiento se guardo o actualizó correctamente
            return true;
        }
        // si no se guardo o actualizó correctamente
        return false;
    }

    //Eliminar movimiento por id
    public boolean deleteMovimiento(Integer id){
        movimientosRepository.deleteById(id); //Eliminar usando el metodo que nos ofrece el repositorio
        if(this.movimientosRepository.findById(id).isPresent()){
            //Si al buscar el movimiento lo encontramos, no se eliminó (false)
            return false;
        }
        //Si al buscar el movimiento no lo encontramos, si lo eliminò (true)
        return true;
    }

    //Obterner teniendo en cuenta el id del empleado
    public ArrayList<MovimientoDinero> obtenerPorEmpleado(Integer id) {
        return movimientosRepository.findByEmpleado(id);
    }

    //Obtener movimientos teniendo en cuenta el id de la empresa a la que pertencen los empleados que la registraron
    public ArrayList<MovimientoDinero> obtenerPorEmpresa(Integer id) {
        return movimientosRepository.findByEmpresa(id);
    }

    //Servicio para ver la suma de todos los montos
    public Long obtenerSumaMontos(){
        return movimientosRepository.SumarMonto();
    }

    //Servicio para ver la suma de los montos por empleado
    public Long MontosPorEmpleado(Integer id){
        return movimientosRepository.MontosPorEmpleado(id);
    }

    //Servicio para ver la suma de los montos por empresa
    public Long MontosPorEmpresa(Integer id){
        return movimientosRepository.MontosPorEmpresa(id);
    }

}
