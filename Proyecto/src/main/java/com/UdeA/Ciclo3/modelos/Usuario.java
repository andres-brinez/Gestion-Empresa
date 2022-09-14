package com.UdeA.Ciclo3.modelos;
import javax.persistence.*;

@Entity // Una entidad es la representación de información que nosotros necesitamos en nuestra aplicación.
@Table(name="Usuarioo") // indicamos el nombre de la tabla en la base de datos
// la entidad está relacionada con una tabla de base  de datos
public class Usuario {

    @Id // indica que es la llave primaria
    //@GeneratedValue(strategy = GenerationType.AUTO)  el id se auto incrementa
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Se basa en una columna de base de datos con incremento automático y permite que la base de datos genere un nuevo valor con cada operación de inserción
    private String nombre;
    private String password;
    private String rol;

    private Boolean estado; //para saber si está activo o inactivo


    //relación - muchos a  uno
    // puede haber muchos usuarios  para una empresa
    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    // constructor
    public Usuario() {}

    public Usuario(String nombre, String password, String rol, Empresa empresa, Boolean estado) {
        this.nombre = nombre;
        this.password = password;
        this.rol = rol;
        this.empresa = empresa;
    }


    // getters and setters
    public Empresa getEmpresa() {return empresa;}

    public void setEmpresa(Empresa empresa) {this.empresa = empresa;}

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public String getRol() {return rol;}

    public void setRol(String rol) {this.rol = rol;}

    public Boolean getEstado() {return estado;
    }

    public void setEstado(Boolean estado) {this.estado = estado;
    }
}
