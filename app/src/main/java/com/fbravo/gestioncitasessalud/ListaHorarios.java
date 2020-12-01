package com.fbravo.gestioncitasessalud;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class ListaHorarios extends AppCompatActivity {

    DatePickerDialog picker;
    EditText txtCalendar;
    TextView NombreUsuario,DNIusuario,EdadUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_horarios);
        asignarReferencias();
    }
    private void asignarReferencias(){
        NombreUsuario = findViewById(R.id.EntradaUserCitas);
        DNIusuario = findViewById(R.id.DNIUserCitas);
        EdadUsuario =findViewById(R.id.EdadUserCitas);
        NombreUsuario.setText(MainActivity.name+" "+MainActivity.lastnamep +" "+MainActivity.lastnamem);
        DNIusuario.setText(MainActivity.dni);
        EdadUsuario.setText(MainActivity.edad +" años");

        txtCalendar=findViewById(R.id.txtCalendar);
        txtCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarCalendario();
            }
        });
    }
    private void mostrarCalendario(){
        Calendar calendar=Calendar.getInstance();
        int dia=calendar.get(calendar.DAY_OF_MONTH);
        int mes=calendar.get(calendar.MONTH);
        int anio=calendar.get(calendar.YEAR);
        picker=new DatePickerDialog(ListaHorarios.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        txtCalendar.setText(dayOfMonth+" / "+(month+1)+" / "+year);
                    }
                },anio,mes,dia);
        picker.show();
    }
}