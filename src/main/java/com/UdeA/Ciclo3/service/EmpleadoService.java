package com.UdeA.Ciclo3.service;

import com.UdeA.Ciclo3.modelos.Empleado;
import com.UdeA.Ciclo3.repo.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class EmpleadoService {

    @Autowired //Conectamos esta clase con el repository de Empleado
    EmpleadoRepository empleadoRepository; //Creamos un objeto tipo EmpleadoRepository para poder usar los metodos que dicha clase hereda

    //Metodo que retornará la lista de Empleados usando metodos heredados del jpaRepository
    public List<Empleado> getAllEmpleados(){
        List<Empleado> EmpleadoList = new ArrayList<>(); //Creamos una lista de Empleados
        empleadoRepository.findAll().forEach(Empleado -> EmpleadoList.add(Empleado));  //Recorremos el iterable que regresa el metodo findAll del Jpa y lo guardamos en la lista creada
        return EmpleadoList;
    }

    // Metodo para Buscar empleado por  id usando metodos heredados del jpaRepository
    // optional significa que puede o no retornar un valor
    public Optional<Empleado> getEmpleadoById(Integer id){

        return empleadoRepository.findById(id);
    }

    //Metodo para guardar o actualizar un  Empleado
    public boolean saveOrUpdateEmpleado(Empleado Empleado){
        Empleado emp=empleadoRepository.save(Empleado);
        if (empleadoRepository.findById(emp.getId())!=null){
            // si el empleado existe, es decir que se creó o actualizó
            return true;
        }
        // si el empleado no existe, significa que hay un error
        return false;
    }

    //Metodo para eliminar Empleados
    public boolean deleteEmpleado(Integer id){
        empleadoRepository.deleteById(id);  //Elimina el empleado con el id que se le pasa

        if (empleadoRepository.findById(id)!=null){  //Verificacion del servicio eliminacion
            /// si el empleado existe hubo un error porque no se eliminó
            return true;
        }
        // si el empleado no existe, es decir que se elimino correctamente
        return false;
    }

    //Metodo para buscar empleados por empresa
    public ArrayList<Empleado> obtenerPorEmpresa(Integer id){
        return empleadoRepository.findByEmpresa(id);
    }
}
