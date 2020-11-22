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
    Button btn_cita;
    
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
    }
    private void asignarReferencias() {
        NombreUsuario = findViewById(R.id.NombreUsuario);
        DNIusuario = findViewById(R.id.DNIusuario);
        NombreUsuario.setText("Bienvenido " + MainActivity.name+" "+MainActivity.lastnamep +" "+MainActivity.lastnamem);
        DNIusuario.setText(MainActivity.dni);
        btn_cita=findViewById(R.id.btn_cita);

    }
    public void openActivity() {
        Intent intent = new Intent(this, MenuCitas.class);
        startActivity(intent);
    }
}
