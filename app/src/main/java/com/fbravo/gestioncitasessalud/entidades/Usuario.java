package com.fbravo.gestioncitasessalud.entidades;

public class Usuario {

   // `id` INT NOT NULL ,
    // `NOMBRE` VARCHAR NOT NULL ,
    //
    // `APELLIDOPATE` VARCHAR NOT NULL ,
    // `APELLIDOMATE` VARCHAR NOT NULL ,
    // `DNI` VARCHAR(8) NOT NULL ,
    // `FECHNACIMIENTO` DATE NOT NULL ,
    // `GENERO` BINARY NOT NULL ,
    // `PASSWORD` VARCHAR NOT NULL

    private  int id;
    private String nombre;
    private String apellidoPate;
    private String apellidoMate;
    private String dni;
    private String fechaNacimiento;
    private String genero;
    private String password;

    public Usuario(int id, String nombre, String apellidoPate, String apellidoMate, String dni, String fechaNacimiento, String genero, String password) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPate = apellidoPate;
        this.apellidoMate = apellidoMate;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.password = password;
    }
    public Usuario(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPate() {
        return apellidoPate;
    }

    public void setApellidoPate(String apellidoPate) {
        this.apellidoPate = apellidoPate;
    }

    public String getApellidoMate() {
        return apellidoMate;
    }

    public void setApellidoMate(String apellidoMate) {
        this.apellidoMate = apellidoMate;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
