package com.UdeA.Ciclo3.repo;

import com.UdeA.Ciclo3.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository //Anotacion que le dice a Spring que esta clase es un repositorio
// relación con una entidad                    nombre de la entidad  primary key de la entidad (el tipo de dato )
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    // trae la información que está en  la tabla relacionada con la entidad Empresa
    // hereda el  JpaRepository que es eliminar, editar, guardar, actualizar, buscar por id, buscar todos, etc

}
