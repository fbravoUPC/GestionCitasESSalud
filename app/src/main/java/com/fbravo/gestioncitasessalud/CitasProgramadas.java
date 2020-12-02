package com.fbravo.gestioncitasessalud;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
import com.fbravo.gestioncitasessalud.entidades.Cita;
import com.fbravo.gestioncitasessalud.entidades.CitaSede;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CitasProgramadas extends AppCompatActivity {
    ListView lstCitas;
    TextView NombreUsuario,DNIusuario,EdadUsuario,NomDoctor,NomSede,NomFecha,NomEspecialidad;

    RecyclerView recyclerView;



    ArrayList<CitaSede> listaCitas = new ArrayList<>();
    AdaptadorCita customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_citas_programadas);
              asignarReferencias();
        listarcitas();

    }

    private void asignarReferencias() {
        lstCitas = findViewById(R.id.lstCitas);
        NombreUsuario = findViewById(R.id.NombreCitasProgramada);
        DNIusuario = findViewById(R.id.DNICitasProgramadas);
        EdadUsuario = findViewById(R.id.EdadCitasProgramadas);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        NombreUsuario.setText(MainActivity.name+" "+MainActivity.lastnamep +" "+MainActivity.lastnamem);
        DNIusuario.setText(MainActivity.dni);
        EdadUsuario.setText(MainActivity.edad +" años");

        NomDoctor = findViewById(R.id.NomDoctor);
        NomEspecialidad = findViewById(R.id.NomEspecialidad);
        NomFecha = findViewById(R.id.NomFecha);
        NomSede = findViewById(R.id.NomSede);

    }

    private void listarcitas() {

        String dni = MainActivity.dni.toString();
        String url = "http://essalud.atwebpages.com/index.php/citas/"+dni;

        StringRequest peticion = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {



                    JSONArray arreglo= new JSONArray(response);
                    //List<String> items = new ArrayList<>();
                   // List<CitaSede> items = new ArrayList<>();
                    ArrayList<CitaSede> items = new ArrayList<>();
                    for (int i=0;i<arreglo.length();i++){
                        JSONObject objeto = arreglo.getJSONObject(i);
                        CitaSede cita = new CitaSede( objeto.getString("nombre_doctor")+ " "+ objeto.getString("apellido_doctor"),objeto.getString("distrito"),objeto.getString("fecha"),objeto.getString("nombreespecialidad"));

                       // items.add("Doctor:"+ objeto.getString("nombre_doctor")+ " "+ objeto.getString("apellido_doctor")+"\n"+ "Especialidad:"+objeto.getString("nombreespecialidad")+"\n"+"Fecha: "+objeto.getString("fecha")+" "+objeto.getString("hora") +"\n"+"Sede: "+objeto.getString("distrito"));
                        items.add(cita);

                    }




                    ArrayAdapter<CitaSede> adapter = new ArrayAdapter<>( CitasProgramadas.this,android.R.layout.simple_list_item_1,items);
                    lstCitas.setAdapter(adapter);
                    customAdapter = new AdaptadorCita(CitasProgramadas.this,items);


                    recyclerView.setAdapter(customAdapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(CitasProgramadas.this));




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