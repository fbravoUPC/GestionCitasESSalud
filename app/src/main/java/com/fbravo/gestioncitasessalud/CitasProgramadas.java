package com.fbravo.gestioncitasessalud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class CitasProgramadas extends AppCompatActivity {
    TextView NombreUsuario,DNIusuario,EdadUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citas_programadas);
        asignarReferencias();
    }

    private void asignarReferencias() {
        NombreUsuario = findViewById(R.id.NombreUserCitaPro);
        DNIusuario = findViewById(R.id.DNIUserCitaPro);
        EdadUsuario =findViewById(R.id.EdadUserCitaPro);
        NombreUsuario.setText(MainActivity.name+" "+MainActivity.lastnamep +" "+MainActivity.lastnamem);
        DNIusuario.setText(MainActivity.dni);
        EdadUsuario.setText(MenuCitas.edad +" años");


    }
}