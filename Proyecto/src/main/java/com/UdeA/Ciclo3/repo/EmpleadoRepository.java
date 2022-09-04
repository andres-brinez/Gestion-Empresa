package com.UdeA.Ciclo3.repo;

import com.UdeA.Ciclo3.modelos.Empleado;
import com.UdeA.Ciclo3.modelos.Empresa;
import com.UdeA.Ciclo3.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //Anotacion que le dice a Spring que esta clase es un repositorio

// relación con una entidad                    nombre de la entidad  primary key de la entidad (el tipo de dato )
public interface EmpleadoRepository extends JpaRepository<Empleado,Integer> {
// trae la información que está en  la tabla relacionada con la entidad Empresa
// hereda el  JpaRepository que es eliminar, editar, guardar, actualizar, buscar por id, buscar todos, etc

}

