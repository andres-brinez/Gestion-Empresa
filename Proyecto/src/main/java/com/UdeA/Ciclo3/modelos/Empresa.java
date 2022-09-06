package com.UdeA.Ciclo3.modelos;

import javax.persistence.*;
import javax.persistence.*;

@Entity // Una entidad es la representación de información que nosotros necesitamos en nuestra aplicación.
@Table(name="Empresa") // indicamos el nombre de la tabla en la base de datos
// la entidad está relacionada con una tabla de base  de datos
public class Empresa {

    // atributos, que en la tabla serán las columnas
    private String nombre;
    private String direccion;
    private String telefono;
    private String NIT;
    @Id // indicamos que este atributo (id)  será la clave primaria de la tabla
    //@GeneratedValue(strategy = GenerationType.AUTO) // indicamos que este valor de la tabla (id) será autoincrementable
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Se basa en una columna de base de datos con incremento automático y permite que la base de datos genere un nuevo valor con cada operación de inserción

    private int id;

    // constructor
    public Empresa() {}
    public Empresa(String nombre, String direccion, String telefono, String NIT) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.NIT = NIT;
    }

    // Getters and setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
