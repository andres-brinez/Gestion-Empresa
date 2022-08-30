package com.UdeA.Ciclo3.repo;

import com.UdeA.Ciclo3.modelos.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// relación con una entidad                    nombre de la entidad  primary key de la entidad (el tipo de dato )
public interface EmpresaRepositorio extends JpaRepository <Empresa,Integer>{
// trae la información que está en  la tabla relacionada con la entidad Empresa

}
