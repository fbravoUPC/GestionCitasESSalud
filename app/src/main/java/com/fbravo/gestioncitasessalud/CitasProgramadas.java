package com.fbravo.gestioncitasessalud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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
import java.util.List;

public class CitasProgramadas extends AppCompatActivity {
    ListView lstCitas;
    TextView NombreUsuario,DNIusuario,EdadUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citas_programadas);
        lstCitas = findViewById(R.id.lstCitas);
        asignarReferencias();
        listarcitas();
    }

    private void asignarReferencias() {
        NombreUsuario = findViewById(R.id.NombreCitasProgramada);
        DNIusuario = findViewById(R.id.DNICitasProgramadas);
        EdadUsuario = findViewById(R.id.EdadCitasProgramadas);
        NombreUsuario.setText(MainActivity.name+" "+MainActivity.lastnamep +" "+MainActivity.lastnamem);
        DNIusuario.setText(MainActivity.dni);
        EdadUsuario.setText(MainActivity.edad +" años");
    }

    private void listarcitas() {

        String dni = MainActivity.dni.toString();
        String url = "http://essalud.atwebpages.com/index.php/citas/"+dni;

        StringRequest peticion = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray arreglo= new JSONArray(response);
                    List<String> items = new ArrayList<>();
                    for (int i=0;i<arreglo.length();i++){
                        JSONObject objeto = arreglo.getJSONObject(i);
                        // items.add("Doctor: "+ objeto.getString("nombre_doctor")+" "+  objeto.getString("apellido_doctor")+ " Especialidad: "+objeto.getString("nombreespecialidad")+" Fecha: "+objeto.getString("fecha")+" "+objeto.getString("hora") +" Sede: "+objeto.getString("distrito"));
                        items.add("Doctor:"+ objeto.getString("nombre_doctor")+ " "+ objeto.getString("apellido_doctor")+"\n"+ "Especialidad:"+objeto.getString("nombreespecialidad")+"\n"+"Fecha: "+objeto.getString("fecha")+" "+objeto.getString("hora") +"\n"+"Sede: "+objeto.getString("distrito"));

                    }

                    ArrayAdapter<String> adapter = new ArrayAdapter<>( CitasProgramadas.this,android.R.layout.simple_list_item_1,items);
                    lstCitas.setAdapter(adapter);
                }catch (JSONException e){
                    Toast.makeText(CitasProgramadas.this, e.getMessage(),Toast.LENGTH_SHORT).show();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(CitasProgramadas.this, error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue cola = Volley.newRequestQueue(this);
        cola.add(peticion);

    }
}