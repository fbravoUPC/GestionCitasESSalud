package com.fbravo.gestioncitasessalud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

public class MenuCitas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_citas);

        int años = Integer.parseInt(MainActivity.fnac);
        int edad = 2020 - años;
    }
}