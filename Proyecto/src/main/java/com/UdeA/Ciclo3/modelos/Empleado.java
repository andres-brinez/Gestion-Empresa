package com.UdeA.Ciclo3.modelos;
import javax.persistence.*;

@Entity // Una entidad es la representación de información que nosotros necesitamos en nuestra aplicación.
@Table(name="Empleado") // indicamos el nombre de la tabla en la base de datos
// la entidad está relacionada con una tabla de base  de datos
public class Empleado {

    @Id // indica que es la llave primaria
    //@GeneratedValue(strategy = GenerationType.AUTO)  el id se auto incrementa
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Se basa en una columna de base de datos con incremento automático y permite que la base de datos genere un nuevo valor con cada operación de inserción

    private  int id;

    private String nombre;
    private String correo;
    private String rol;


    //relación - muchos a  uno
    // puede haber muchos empleados  para una empresa
    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    // constructor
    public Empleado() {}

    public Empleado(String nombre, String correo, String rol, Empresa empresa) {
        this.nombre = nombre;
        this.correo = correo;
        this.rol = rol;
        this.empresa = empresa;
    }

    // getters and setters
    public Empresa getEmpresa() {return empresa;}

    public void setEmpresa(Empresa empresa) {this.empresa = empresa;}

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getCorreo() {return correo;}

    public void setCorreo(String correo) {this.correo = correo;}

    public String getRol() {return rol;}

    public void setRol(String rol) {this.rol = rol;}
}
