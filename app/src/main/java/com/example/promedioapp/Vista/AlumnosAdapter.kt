package com.example.promedioapp.Vista

import android.graphics.pdf.models.ListItem
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.promedioapp.Modelo.AlumnosDatos
import com.example.promedioapp.R
import kotlinx.coroutines.processNextEventInCurrentThread

//Temenos Herencia en RecyclerViwe
class AlumnosAdapter (val alumnos: List<AlumnosDatos>): RecyclerView.Adapter<AlumnosAdapter.misControles>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): misControles {
        val vista= LayoutInflater.from(parent.context).inflate(R.layout.datos,parent,false)

        return misControles(vista)
    }

    override fun onBindViewHolder(holder: misControles, position: Int) {
        val listaAlumno= alumnos[position]
        holder.foto.setImageResource(listaAlumno.foto)
        holder.txtNombre.text= listaAlumno.nombre
        holder.txtPromedio.text= "Promedio: ${listaAlumno.promedio}"
    }

    override fun getItemCount(): Int { //Cunatos elementos hay en la lista
        return alumnos.size
    }

    //Creamos mi Holder (Indica que va a trabajar con el Recycler y va a estar tomando los item o posiciones)
    class misControles(item: View): RecyclerView.ViewHolder(item){


        //Referencias de datos.xml
        val foto: ImageView = item.findViewById(R.id.imgFoto)
        val txtNombre: TextView= item.findViewById(R.id.txtNombre)
        val txtPromedio: TextView= item.findViewById(R.id.txtPromedio)
        val txtTipoBeca: TextView= item.findViewById(R.id.txtTipoBeca)
        val txtMonto: TextView= item.findViewById(R.id.txtMonto)

    }
}