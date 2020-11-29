package com.fbravo.gestioncitasessalud;

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

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMAp;
    float latitud, longitud;
    String titulo;

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
        recuperarDatos();

        LatLng upc = new LatLng(latitud,longitud);
        mMAp.addMarker(new MarkerOptions().position(upc).title(titulo).icon(cambiarIcono(getApplicationContext(),R.drawable.shop)));
        mMAp.animateCamera(CameraUpdateFactory.newLatLngZoom(upc, 16));
    }
    private void recuperarDatos() {
        latitud = Float.parseFloat(getIntent().getStringExtra("latitud"));
        longitud = Float.parseFloat(getIntent().getStringExtra("longitud"));
        titulo = getIntent().getStringExtra("titulo");
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




