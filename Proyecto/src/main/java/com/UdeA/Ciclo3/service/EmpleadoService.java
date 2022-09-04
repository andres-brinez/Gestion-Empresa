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

    // Metodo para ver todos los empleados registrados
    public Optional<Empleado> getgetEmpleadoById(Integer id){
        //Metodo que me trae un objeto de tipo Empleado cuando cuento con el id de la misma
        return empleadoRepository.findById(id);
    }

    //Metodo para guardar o actualizar objetos de tipo Empleado
    public boolean saveOrUpdateEmpleado(Empleado Empleado){
        Empleado emp=empleadoRepository.save(Empleado);
        if (empleadoRepository.findById(emp.getId())!=null){
            return true;
        }
        return false;
    }

    //Metodo para eliminar Empleados registradas teniendo el id
    public boolean deleteEmpleado(Integer id){
        empleadoRepository.deleteById(id);  //Eliminar

        if (empleadoRepository.findById(id)!=null){  //Verificacion del servicio eliminacion
            return true;
        }
        return false;
    }
}
