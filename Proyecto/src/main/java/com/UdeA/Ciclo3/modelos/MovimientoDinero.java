package com.UdeA.Ciclo3.modelos;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


@Entity // más  información en la clase Empresa
@Table(name="Movimientos")  // indica que esta entidad es  una tabla  y cúal es el nombre

public class MovimientoDinero {
    // atributos- columnas de  la tabla

    @Id // este atributo es una primary key
    //@GeneratedValue(strategy = GenerationType.AUTO) // es  un valor auto incrementable
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Se basa en una columna de base de datos con incremento automático y permite que la base de datos genere un nuevo valor con cada operación de inserción

    private int id;

    private long  monto;
    private String concepto;

    // Relacion- muchos a uno
    // un usuario (empleado ) pude hacer muchos movimientod
    @ManyToOne
    @JoinColumn(name = "empleado_id")
    private Empleado usuario;

    // Postgres tiene el siguiente formato de fecha AAAA-MM-DD
    @DateTimeFormat(pattern="yyyy-MM-dd") // da el formato en el que se vá a guardar la fecha en la base de datos
    private Date fecha;

    // constructor
    public MovimientoDinero() {
    }

    public MovimientoDinero(int id, long monto, String concepto, Empleado usuario, Date fecha) {
        this.id = id;
        this.monto = monto;
        this.concepto = concepto;
        this.usuario = usuario;
        this.fecha = fecha;
    }

    // getters

    public int getId() {
        return id;
    }

    public long getMonto() {
        return monto;
    }

    public String getConcepto() {
        return concepto;
    }

    public Empleado getUsuario() {
        return usuario;
    }

    public Date getFecha() {
        return fecha;
    }

    // setters

    public void setMonto(long monto) {
        this.monto = monto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public void setUsuario(Empleado usuario) {
        this.usuario = usuario;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
