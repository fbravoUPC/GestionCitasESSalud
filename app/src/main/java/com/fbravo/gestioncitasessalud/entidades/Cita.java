package com.fbravo.gestioncitasessalud.entidades;

import java.util.Date;

public class Cita {
    int id, id_doctor, id_usuario, id_sede, id_especialidad, id_horario;
    Date fecha;

    public Cita(int id, int id_doctor, int id_usuario, int id_sede, int id_especialidad, int id_horario, Date fecha) {
        this.id = id;
        this.id_doctor = id_doctor;
        this.id_usuario = id_usuario;
        this.id_sede = id_sede;
        this.id_especialidad = id_especialidad;
        this.id_horario = id_horario;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_doctor() {
        return id_doctor;
    }

    public void setId_doctor(int id_doctor) {
        this.id_doctor = id_doctor;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_sede() {
        return id_sede;
    }

    public void setId_sede(int id_sede) {
        this.id_sede = id_sede;
    }

    public int getId_especialidad() {
        return id_especialidad;
    }

    public void setId_especialidad(int id_especialidad) {
        this.id_especialidad = id_especialidad;
    }

    public int getId_horario() {
        return id_horario;
    }

    public void setId_horario(int id_horario) {
        this.id_horario = id_horario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
