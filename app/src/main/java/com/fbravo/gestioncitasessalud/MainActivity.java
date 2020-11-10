package com.fbravo.gestioncitasessalud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtUsuario,txtPassword;
    Button btnEntrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUsuario=findViewById(R.id.edtUser);
        txtPassword=findViewById(R.id.edtPassword);
        btnEntrar=findViewById(R.id.btnEntrar);
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtUsuario.getText().toString().equals("")||
                       txtPassword.getText().toString().equals("") ){
                    //Mostrar toast
                    Toast toast= Toast.makeText(MainActivity.this,"Llena todos los campos",Toast.LENGTH_LONG);
                    toast.show();
                }else  {
                    //Navegar a la nueva pantalla
                    
                }
            }
        });

    }
}