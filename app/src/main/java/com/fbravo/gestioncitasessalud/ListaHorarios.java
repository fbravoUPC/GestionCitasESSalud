package com.fbravo.gestioncitasessalud;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListaHorarios extends AppCompatActivity {

    DatePickerDialog picker;
    EditText txtCalendar;
    TextView NombreUsuario,DNIusuario,EdadUsuario;
    Button btn_ViewHorarios,btn_ConfirmarHorarios;
    ListView listaHorarios;
    String id_especialidad;
    String id_sede;
    String id_usuario, id_doctor,      fecha,    id_horario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_horarios);
        asignarReferencias();
    }
    private void asignarReferencias(){

        NombreUsuario = findViewById(R.id.NombreUsuario);
        DNIusuario = findViewById(R.id.DNIusuario);
        EdadUsuario =findViewById(R.id.EdadUsuario);
        listaHorarios =findViewById(R.id.listaHorarios);

        NombreUsuario.setText(MainActivity.name+" "+MainActivity.lastnamep +" "+MainActivity.lastnamem);
        DNIusuario.setText(MainActivity.dni);
        EdadUsuario.setText(MainActivity.edad +" años");

        btn_ViewHorarios=findViewById(R.id.btn_ViewHorarios);
        btn_ViewHorarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarHorarios();
            }
        });

        btn_ConfirmarHorarios=findViewById(R.id.btn_ViewHorarios);
        btn_ConfirmarHorarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarCita();
            }
        });

        txtCalendar=findViewById(R.id.txtCalendar);
        txtCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarCalendario();
            }
        });
    }

    private void registrarCita() {
        String url="http://essalud.atwebpages.com/index.php/doctores/";

        StringRequest peticion = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(ListaHorarios.this, "Se inserto correctamente", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ListaHorarios.this, error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros= new HashMap<>();
                parametros.put("$ID_USUARIO",id_usuario);
                parametros.put("$ID_DOCTOR",id_doctor);
                parametros.put("$ID_SEDE",id_sede);
                parametros.put("$ID_ESPECIALIDAD",id_especialidad);
                parametros.put("$fecha",fecha);
                parametros.put("$ID_HORARIO",id_horario);

                return parametros;
            }
        };

        RequestQueue cola = Volley.newRequestQueue(this);
        cola.add(peticion);
    }

    private void mostrarHorarios() {
        id_especialidad= "1" ;
        id_sede="1";
        String url="http://essalud.atwebpages.com/index.php/doctores/";

        StringRequest peticion = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray arreglo= new JSONArray(response);
                    List<String> items = new ArrayList<>();
                    for (int i=0;i<arreglo.length();i++){
                        JSONObject objeto = arreglo.getJSONObject(i);
                        items.add("Doctor: "+ objeto.getString("NOMBRE")+" "+  objeto.getString("APELLIDOPATE"));
                    }

                    ArrayAdapter<String> adapter = new ArrayAdapter<>( ListaHorarios.this,android.R.layout.simple_list_item_1,items);
                    listaHorarios.setAdapter(adapter);
                }catch (JSONException e){
                    Toast.makeText(ListaHorarios.this, e.getMessage(),Toast.LENGTH_SHORT).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ListaHorarios.this, error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros= new HashMap<>();
                parametros.put("id_especialidad",id_especialidad);
                parametros.put("id_sede",id_sede);
                return parametros;

            }
        };

        RequestQueue cola = Volley.newRequestQueue(this);
        cola.add(peticion);

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