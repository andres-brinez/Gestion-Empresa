package com.UdeA.Ciclo3.repo;

import com.UdeA.Ciclo3.modelos.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
// la explicación está en el archivo EmpleadoRepository
public interface MovimientosRepository extends JpaRepository<MovimientoDinero, Integer> {
    // como jpaRepository ya tiene los metodos de crud no es necesario crearlos
    // solo se crea el metodo que se necesite como en este momento

    //Metodo para filtrar movimientos por empleado, el empleado se obtiene por el id
    @Query(value ="select * from movimientos where empleado_id= ?1", nativeQuery = true)
    public abstract ArrayList<MovimientoDinero> findByEmpleado(Integer id);

    //Metodo para filtrar movimientos por empresa, la empresa se obtiene por el id
    @Query(value="select * from movimientos where empleado_id in (select id from empleado where empresa_id= ?1)", nativeQuery = true)
    public abstract ArrayList<MovimientoDinero> findByEmpresa(Integer id);
}