package com.fbravo.gestioncitasessalud.entidades;

public class CitaSede {

    String NomDoctor, NomSede, NomFecha, NomEspecialidad;

    public String getNomDoctor() {
        return NomDoctor;
    }

    public void setNomDoctor(String nomDoctor) {
        NomDoctor = nomDoctor;
    }

    public String getNomSede() {
        return NomSede;
    }

    public void setNomSede(String nomSede) {
        NomSede = nomSede;
    }

    public String getNomFecha() {
        return NomFecha;
    }

    public void setNomFecha(String nomFecha) {
        NomFecha = nomFecha;
    }

    public String getNomEspecialidad() {
        return NomEspecialidad;
    }

    public void setNomEspecialidad(String nomEspecialidad) {
        NomEspecialidad = nomEspecialidad;
    }

    public CitaSede(String nomDoctor, String nomSede, String nomFecha, String nomEspecialidad) {
        NomDoctor = nomDoctor;
        NomSede = nomSede;
        NomFecha = nomFecha;
        NomEspecialidad = nomEspecialidad;
    }




}
