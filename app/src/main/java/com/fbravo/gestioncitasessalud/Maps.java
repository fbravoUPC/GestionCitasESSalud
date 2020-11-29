package com.fbravo.gestioncitasessalud;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class Maps extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMAp;
    float latitud, longitud;
    String titulo;
   // boolean varios = false;

    ArrayList<LatLng> listaPuntos = new ArrayList<>();
    ArrayList<String> listaTitulos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment = (SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMAp = googleMap;

        mMAp.getUiSettings().setZoomControlsEnabled(true);
//        recuperarDatos();
     //   if (varios == false) {
            LatLng upc = new LatLng(latitud, longitud);
            mMAp.addMarker(new MarkerOptions().position(upc).title(titulo).icon(cambiarIcono(getApplicationContext(), R.drawable.ic_sede1)));
            mMAp.animateCamera(CameraUpdateFactory.newLatLngZoom(upc, 16));
        }else {
            mostrarVarios();
            for (int i=0; i<listaPuntos.size(); i++){
                mMAp.addMarker(new MarkerOptions().position(listaPuntos.get(i)).title(""+listaTitulos.get(i)));
            }
            mMAp.animateCamera(CameraUpdateFactory.newLatLngZoom(listaPuntos.get(listaPuntos.size()-1), 16));
            mMAp.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                @Override
                public boolean onMarkerClick(Marker marker) {
                    String marcadorTitulo = marker.getTitle();
                    Intent intent = new Intent(Maps.this, ListaHorario.class);
                    intent.putExtra("titulo", marcadorTitulo);
                    return false;
                }
            });
        }
    }
 //   private void recuperarDatos() {
 //       if (getIntent().hasExtra("varios")){
 //           varios=true;
 //       }
 //       latitud = Float.parseFloat(getIntent().getStringExtra("latitud"));
 //       longitud = Float.parseFloat(getIntent().getStringExtra("longitud"));
 //       titulo = getIntent().getStringExtra("titulo");
 //   }
    private void mostrarVarios() {
        LatLng negreiros = new LatLng(-12.015633, -77.0984722);
        LatLng sabogal = new LatLng(-12.0584037, -77.1161382);
        LatLng rebagliati = new LatLng(-12.0779959,-77.0424019);

        listaPuntos.add(negreiros);
        listaPuntos.add(sabogal);
        listaPuntos.add(rebagliati);

        listaTitulos.add("Hospital Negreiros");
        listaTitulos.add("Hospital Sabogal");
        listaTitulos.add("Hospital Rebagliati");
    }
    private BitmapDescriptor cambiarIcono(Context context, int id) {
        Drawable imagen = ContextCompat.getDrawable(context, id);
        imagen.setBounds(0,0,imagen.getIntrinsicWidth(), imagen.getIntrinsicHeight());
        Bitmap bitmap = Bitmap.createBitmap(imagen.getMinimumWidth(), imagen.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        imagen.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }
}


