package com.fbravo.gestioncitasessalud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class UbicacionSede extends AppCompatActivity {
    TextView NombreUsuario,DNIusuario,EdadUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubicacion_sede);
        asignarReferencias();
    }

    private void asignarReferencias() {
        NombreUsuario = findViewById(R.id.NombreUserSedes);
        DNIusuario = findViewById(R.id.DNIUserSedes);
        EdadUsuario =findViewById(R.id.EdadUserSedes);
        NombreUsuario.setText(MainActivity.name+" "+MainActivity.lastnamep +" "+MainActivity.lastnamem);
        DNIusuario.setText(MainActivity.dni);
        EdadUsuario.setText(MenuCitas.edad +" años");


    }
}