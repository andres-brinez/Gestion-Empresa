package com.UdeA.Ciclo3.modelos;


import javax.persistence.*;

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

    // constructor
    public MovimientoDinero() {}
    public MovimientoDinero(long monto, String concepto, Empleado usuario) {
        this.monto = monto;
        this.concepto = concepto;
        this.usuario = usuario;
    }

    // getters and setters

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public long getMonto() {return monto;}

    public void setMonto(long monto) {this.monto = monto;}

    public String getConcepto() {return concepto;}

    public void setConcepto(String concepto) {this.concepto = concepto;}

    public Empleado getUsuario() {return usuario;}

    public void setUsuario(Empleado usuario) {this.usuario = usuario;}
}
