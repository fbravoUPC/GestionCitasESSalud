package com.fbravo.gestioncitasessalud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

public class MenuCitas extends AppCompatActivity {

    Button btn_ginecologia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_citas);

        //int años = Integer.parseInt(MainActivity.fnac);
        //int edad = 2020 - años;
        btn_ginecologia = findViewById(R.id.btn_ginecologia);
        btn_ginecologia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MenuOptions.cita.setId_especialidad(2);
                openActivity2();

            }
        });
    }
    public void openActivity2() {
        Intent intent = new Intent(this, UbicacionSede.class);
        startActivity(intent);
    }
}