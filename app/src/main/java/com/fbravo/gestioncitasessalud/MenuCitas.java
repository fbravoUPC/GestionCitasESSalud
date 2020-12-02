package com.fbravo.gestioncitasessalud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Map;

public class MenuCitas extends AppCompatActivity {

    Button btn_ginecologia, btn_mamografia, btn_patologia, btn_consulta_general;
    TextView NombreUsuario,DNIusuario,EdadUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_citas);

        asignarReferencias();
        btn_ginecologia = findViewById(R.id.btn_ginecologia);
        btn_ginecologia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // MenuOptions.cita.setId_especialidad(2);
                //openActivity2()
                Intent intent = new Intent(MenuCitas.this, Maps.class);
                intent.putExtra("varios", "mapa");
                startActivity(intent);
            }
        });
        btn_mamografia = findViewById(R.id.btn_mamografia);
        btn_mamografia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // MenuOptions.cita.setId_especialidad(2);
                //openActivity2()
                Intent intent = new Intent(MenuCitas.this, Maps.class);
                intent.putExtra("varios", "mapa");
                startActivity(intent);
            }
        });
        btn_patologia = findViewById(R.id.btn_patologia);
        btn_patologia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // MenuOptions.cita.setId_especialidad(2);
                //openActivity2()
                Intent intent = new Intent(MenuCitas.this, Maps.class);
                intent.putExtra("varios", "mapa");
                startActivity(intent);
            }
        });
        btn_consulta_general = findViewById(R.id.btn_consulta_general);
        btn_consulta_general.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // MenuOptions.cita.setId_especialidad(2);
                //openActivity2()
                Intent intent = new Intent(MenuCitas.this, Maps.class);
                intent.putExtra("varios", "mapa");
                startActivity(intent);
            }
        });

    }

    private void asignarReferencias() {
        NombreUsuario = findViewById(R.id.EntradaUserCitas);
        DNIusuario = findViewById(R.id.DNIUserCitas);
        EdadUsuario =findViewById(R.id.EdadUserCitas);
        NombreUsuario.setText(MainActivity.name+" "+MainActivity.lastnamep +" "+MainActivity.lastnamem);
        DNIusuario.setText(MainActivity.dni);
        EdadUsuario.setText(MainActivity.edad +" años");
        btn_ginecologia=findViewById(R.id.btn_ginecologia);


    }

    // public void openActivity2() {
    //Intent intent = new Intent(this, UbicacionSede.class);
    //startActivity(intent);
    // }
}