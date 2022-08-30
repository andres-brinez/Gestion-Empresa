package com.UdeA.Ciclo3.service;

import com.UdeA.Ciclo3.Repo.EmpresaRepositorio;
import com.UdeA.Ciclo3.modelos.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpresaService {
    @Autowired // se autoconecta con el repositorio y hereda todo lo que puede hacer  como listar,eliminar,editar los valores de la base de datos
    EmpresaRepositorio empresaRepositorio;

    // ver toda las empresas
    public List<Empresa> getAllEmpresas() {
        // crear una lista de empresas
        List<Empresa> empresaList = new ArrayList<>();
        empresaRepositorio.findAll().forEach(empresa -> empresaList.add(empresa)); // recorre todo el contenido de la base de datos y lo agrega a la lista
        return empresaList;
    }

    // editar una empresa
    public Empresa editarEmpresa(Empresa empresa) {
        return empresaRepositorio.save(empresa);
    }

    // obtener una emprera por id
    public Empresa getEmpresaById(int id) {
        return empresaRepositorio.findById(id).get();
    }

    // guardar o actualizar una empresa
    // si la empresa está vacía, se guarda, si no, se actualiza la empresa existente
    public boolean saveorupdateEmpresa(Empresa empresa) {
        Empresa emp = empresaRepositorio.save(empresa);
        if (empresaRepositorio.findById(emp.getId())!=null) {
            return true;
        }
        return false;

    }

    // eliminar una empresa
    public boolean eliminarEmpresa(int id) {
        if (empresaRepositorio.findById(id)!=null) {
            empresaRepositorio.deleteById(id);
            return true;
        }
        return false;
    }
}
