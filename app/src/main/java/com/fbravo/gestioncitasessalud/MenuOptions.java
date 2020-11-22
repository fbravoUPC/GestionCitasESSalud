package com.fbravo.gestioncitasessalud;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MenuOptions extends AppCompatActivity {
    TextView NombreUsuario,DNIusuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_options);
        asignarReferencias();

    }

    private void asignarReferencias() {
        NombreUsuario = findViewById(R.id.NombreUsuario);
        DNIusuario = findViewById(R.id.DNIusuario);

        NombreUsuario.setText("Bienvenido " + MainActivity.name+" "+MainActivity.lastnamep +" "+MainActivity.lastnamem);
        DNIusuario.setText(MainActivity.dni);

    }
}
