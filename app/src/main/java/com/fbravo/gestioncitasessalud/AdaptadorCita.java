package com.fbravo.gestioncitasessalud;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.android.volley.Response;
import com.fbravo.gestioncitasessalud.entidades.CitaSede;

import java.util.ArrayList;

public class AdaptadorCita extends RecyclerView.Adapter<AdaptadorCita.MyViewHolder> {


    private Context context;
    private ArrayList<CitaSede> listacitas = new ArrayList<>();
    Activity activity;

    //public AdaptadorCita(Activity activity, Response.Listener<CitaSede> context, ArrayList<CitaSede>listacitas){
    public AdaptadorCita(Context context,  ArrayList<CitaSede>listacitas){
        this.context = (Context) context;
        this.listacitas = listacitas;

    }

    @NonNull
    @Override
    public AdaptadorCita.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.listcitas,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorCita.MyViewHolder holder, final int position) {
        holder.NomDoctor.setText( String.valueOf(listacitas.get(position).getNomDoctor()));
        holder.NomEspecialidad.setText( String.valueOf(listacitas.get(position).getNomEspecialidad()));
        holder.NomSede.setText( String.valueOf(listacitas.get(position).getNomSede()));
        holder.NomFecha.setText( String.valueOf(listacitas.get(position).getNomFecha()));

    }

    @Override
    public int getItemCount() {
        return listacitas.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView NomDoctor, NomEspecialidad, NomSede,NomFecha;
       // LinearLayout mainLayout;
        ImageView image;
        public MyViewHolder(@NonNull View itemView){
            super(itemView);

            NomDoctor = itemView.findViewById(R.id.NomDoctor);
            NomEspecialidad = itemView.findViewById(R.id.NomEspecialidad);
            NomSede = itemView.findViewById(R.id.NomSede);
            NomFecha = itemView.findViewById(R.id.NomFecha);
           // mainLayout = itemView.findViewById(R.id.mainLayout);
            image = itemView.findViewById(R.id.Clinicaicon);

        }


    }
}
