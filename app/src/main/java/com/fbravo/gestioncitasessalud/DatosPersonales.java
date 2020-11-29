
package com.fbravo.gestioncitasessalud;

        import androidx.appcompat.app.AppCompatActivity;

        import android.os.Bundle;
        import android.widget.TextView;

public class DatosPersonales extends AppCompatActivity {
    TextView NombreUsuario,DNIusuario,EdadUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datos_personales);
        asignarReferencias();
    }

    private void asignarReferencias() {
        NombreUsuario = findViewById(R.id.NombreUserDatPer);
        DNIusuario = findViewById(R.id.DNIUserDatPer);
        EdadUsuario =findViewById(R.id.EdadUserDatPer);
        NombreUsuario.setText(MainActivity.name+" "+MainActivity.lastnamep +" "+MainActivity.lastnamem);
        DNIusuario.setText(MainActivity.dni);



    }
}