package com.UdeA.Ciclo3.repo;

import com.UdeA.Ciclo3.modelos.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository //Anotacion que le dice a Spring que esta clase es un repositorio

// relación con una entidad                    nombre de la entidad  primary key de la entidad (el tipo de dato )
public interface EmpleadoRepository extends JpaRepository<Empleado,Integer> {
// trae la información que está en  la tabla relacionada con la entidad Empresa
// hereda el  JpaRepository que es eliminar, editar, guardar, actualizar, buscar por id, buscar todos, etc


    // se cra un metodo para encontrar los empleados por empresa porque me parece que la clase JpaRepository no tiene ese metodo
    // indicamos la consulta que se va a realizar con una query
    // consejo: las query deben porbarce  primero en la base de datos  para ver si funciona
    // trae  todos los empleados de  una empresa que es  identificado por el id
    @Query(value="SELECT * FROM empleado where empresa_id= ?1", nativeQuery=true)
    // guarda a los empledados que de  una misma empresa que son identificados por el id
    public abstract ArrayList<Empleado> findByEmpresa(Integer id);
}

