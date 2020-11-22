package com.fbravo.gestioncitasessalud;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.fbravo.gestioncitasessalud.entidades.Usuario;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText txtDNI,txtPassword;
    Button btnEntrar;
    public static int edad;
    Usuario usuario;
    public static String name,lastnamep,lastnamem,pwd,pwd2,dni,fnac;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


      /**  String year= fnac.substring(0,4);
         int fechanac = Integer.parseInt(year);
         edad = 2020 - fechanac;**/
       asginarReferencias();


    }

    private void asginarReferencias() {
        txtDNI=findViewById(R.id.edtDNI);
        txtPassword=findViewById(R.id.edtPassword);
        btnEntrar=findViewById(R.id.btnEntrar);
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validar()){
                buscarUsuarios();

                }
            }
        });
    }

    private void buscarUsuarios(){

        String texto=txtDNI.getText().toString();
        String url="http://essalud.atwebpages.com/index.php/usuarios/"+texto;



        StringRequest peticion=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {




                    pwd2= txtPassword.getText().toString();
                    JSONArray arreglo= new JSONArray(response);
                    JSONObject objeto = arreglo.getJSONObject(0);
                    pwd=objeto.getString("password");

                    if (pwd2.equals(pwd)  )
                    {
                        name= objeto.getString("nombre");
                        lastnamep=objeto.getString("apellidopate");
                        lastnamem=objeto.getString("apellidomate");
                        dni=objeto.getString("dni");
                        fnac= objeto.getString("fechnacimiento");

                        Intent intent = new Intent(MainActivity.this, MenuOptions.class);
                        startActivity(intent);
                    }
                    else {
                        Toast toast= Toast.makeText(MainActivity.this,"El password es incorrecto",Toast.LENGTH_LONG);
                        toast.show();
                    }

                }catch (Exception e){
                    Toast.makeText(MainActivity.this, "Usuario y/o password incorrecto",Toast.LENGTH_SHORT).show();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue cola = Volley.newRequestQueue(this);
        cola.add(peticion);





    }


    public boolean validar()
    {
        boolean retorno=true;
        String v1 =txtDNI.getText().toString();
        String v2 =txtPassword.getText().toString();


        if(v1.isEmpty())
        {
            txtDNI.setError("Ingresar DNI de socio");
            //alerta("Ingresar Código de RUT");
            retorno=false;
        }
        if(v2.isEmpty())
        {
            txtPassword.setError("Ingresar password");
            //alerta("Ingresar Código de Accionsita");
            retorno=false;
        }

        return retorno;


    }

    private void  alerta( String Mensaje){
        new AlertDialog.Builder(this)
                .setTitle("Mensaje de Advertencia")
                .setMessage(Mensaje)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .show();
    }
}