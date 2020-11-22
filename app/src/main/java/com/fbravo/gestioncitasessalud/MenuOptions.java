package com.fbravo.gestioncitasessalud;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.fbravo.gestioncitasessalud.entidades.Cita;

public class MenuOptions extends AppCompatActivity {
    TextView NombreUsuario,DNIusuario;
    Button btn_cita, btn_consultar;
    
    public static final Cita cita = null;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_options);
        asignarReferencias();
        btn_cita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
                
            }
        });
        btn_consultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity1();

            }
        });
    }
    private void asignarReferencias() {
        NombreUsuario = findViewById(R.id.NombreUsuario);
        DNIusuario = findViewById(R.id.DNIusuario);
        NombreUsuario.setText(MainActivity.name+" "+MainActivity.lastnamep +" "+MainActivity.lastnamem);
        DNIusuario.setText(MainActivity.dni);
        btn_cita=findViewById(R.id.btn_cita);
        btn_consultar=findViewById(R.id.btn_consultar);
    }
    public void openActivity() {
        Intent intent = new Intent(this, MenuCitas.class);
        startActivity(intent);
    }
    public void openActivity1() {
        Intent intent = new Intent(this, CitasProgramadas.class);
        startActivity(intent);
    }
}
