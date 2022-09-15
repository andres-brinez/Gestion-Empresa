package com.UdeA.Ciclo3.service;


import com.UdeA.Ciclo3.modelos.MovimientoDinero;
import com.UdeA.Ciclo3.modelos.Usuario;

import com.UdeA.Ciclo3.repo.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UsuarioService {

    @Autowired //Conectamos esta clase con el repository de Usuario
    UsuarioRepository usuarioRepository; //Creamos un objeto tipo UsuarioRepository para poder usar los metodos que dicha clase hereda

    //Metodo que retornará una lista de usuarios usando metodos heredados del jpaRepository
    public List<Usuario> getAllUsuarios(){
        List<Usuario> UsuarioList = new ArrayList<>(); //Creamos una lista de Usuarios
        usuarioRepository.findAll().forEach(Usuario -> UsuarioList.add(Usuario));  //Recorremos el iterable que regresa el metodo findAll del Jpa y lo guardamos en la lista creada
        return UsuarioList;
    }

    //Metodo para guardar o actualizar un  Usuario
    public boolean saveOrUpdateUsuario(Usuario Usuario){
        Usuario usu=usuarioRepository.save(Usuario);
        if (usuarioRepository.findById(usu.getId())!=null){
            // si el empleado existe, es decir que se creó o actualizó
            return true;
        }
        // si el empleado no existe, significa que hay un error
        return false;
    }

    //usuario por id
    public Usuario getUsuarioById(Integer id){
        return usuarioRepository.findById(id).get();
    }
    //Metodo para eliminar Usuarios

    public boolean deleteUsuario(int id){
        usuarioRepository.deleteById(id);  //Elimina el empleado con el id que se le pasa

        if (usuarioRepository.findById(id)!=null){  //Verificacion del servicio eliminacion
            /// si el empleado existe hubo un error porque no se eliminó
            return true;
        }
        // si el empleado no existe, es decir que se elimino correctamente
        return false;
    }



}
