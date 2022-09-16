package com.UdeA.Ciclo3.modelos;
import javax.persistence.*;

@Entity // Una entidad es la representación de información que nosotros necesitamos en nuestra aplicación.
@Table(name="Usuario") // indicamos el nombre de la tabla en la base de datos
// la entidad está relacionada con una tabla de base  de datos
public class Usuario {

    @Id // indica que es la llave primaria
    //@GeneratedValue(strategy = GenerationType.AUTO)  el id se auto incrementa
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Se basa en una columna de base de datos con incremento automático y permite que la base de datos genere un nuevo valor con cada operación de inserción
    private int id;

    // indicamos el nombre de la columna en la base de datos es unico
    // @Column(name="UserName", unique = true)
    private String UserName;

    private String nombre;
    private String password;
    private String rol;
    private String correo;
    private String   telefono;


    // constructor
    public Usuario() {
    }

    public Usuario(int id,String userName, String nombre, String password, String rol, String correo, String  telefono ) {
        this.id = id;
        this.UserName = userName;
        this.nombre = nombre;
        this.password = password;
        this.rol = rol;
        this.correo = correo;
        this.telefono = telefono;

    }

    // getters and setters

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public  String  getTelefono() {
        return telefono;
    }

    public void setTelefono( String  telefono) {
        this.telefono = telefono;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
