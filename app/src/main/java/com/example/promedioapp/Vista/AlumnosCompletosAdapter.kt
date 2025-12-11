package com.example.promedioapp.Vista

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.promedioapp.Modelo.clsRespuestaAlumnos
import com.example.promedioapp.R

class AlumnosCompletosAdapter (val contexto : Context, val alumnos: List<clsRespuestaAlumnos>): RecyclerView.Adapter<AlumnosCompletosAdapter.misControles>(){

    //vincular con la pantalla
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): misControles {
        val vista= LayoutInflater.from(parent.context).inflate(R.layout.datos,parent,false)

        return misControles(vista)
    }

    override fun onBindViewHolder(holder: misControles, position: Int) {
        val listaAlumno= alumnos[position]
        holder.txtNombre.text= listaAlumno.nombre
        holder.txtNombre.text= listaAlumno.promedio.toString()
        holder.txtNombre.text= listaAlumno.montoBeca.toString()
    }

    override fun getItemCount(): Int { //Cunatos elementos hay en la lista
        return alumnos.size
    }

    //Creamos mi Holder (Indica que va a trabajar con el Recycler y va a estar tomando los item o posiciones)
    class misControles(item: View): RecyclerView.ViewHolder(item){
        //Referencias de datos.xml
        //val txtNombre: TextView= item.findViewById(R.id.txtNombre)
        //val txtNombre: TextView= item.findViewById(R.id.txtNombre)
        val txtNombre: TextView= item.findViewById(R.id.txtNombre)
    }
}