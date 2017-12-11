package example.omare.com.doit;

import java.sql.Date;

/**
 * Created by Omare on 28-10-2017.
 */

public class User {
    String nombre,apellido,fechaDeNacimiento,password,username;
    int formaDeRegistro;

    public User(String nombre, String apellido, String fechaDeNacimiento, String password, String username) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.password = password;
        this.username = username;
        this.formaDeRegistro = 2;
    }

    public User(String username, String password) {
        this.password = password;
        this.username = username;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(String fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getFormaDeRegistro() {
        return formaDeRegistro;
    }

    public void setFormaDeRegistro(int formaDeRegistro) {
        this.formaDeRegistro = formaDeRegistro;
    }

}


