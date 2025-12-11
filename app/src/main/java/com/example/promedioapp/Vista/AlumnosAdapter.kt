package com.example.promedioapp.Vista

import android.content.Context
import android.content.Intent
import android.graphics.pdf.models.ListItem
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.promedioapp.Modelo.AlumnosDatos
import com.example.promedioapp.Modelo.AlumnosModelo
import com.example.promedioapp.Modelo.clsRespuesta
import com.example.promedioapp.Modelo.clsRespuestaAlumnos
import com.example.promedioapp.Modelo.ifaceApiService
import com.example.promedioapp.R
import kotlinx.coroutines.processNextEventInCurrentThread
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//Temenos Herencia en RecyclerViwe
class AlumnosAdapter (val contexto : Context, val alumnos: List<AlumnosDatos>): RecyclerView.Adapter<AlumnosAdapter.misControles>(){

    val modelo = AlumnosModelo()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): misControles {
        val vista= LayoutInflater.from(parent.context).inflate(R.layout.datos,parent,false)

        return misControles(vista)
    }

    override fun onBindViewHolder(holder: misControles, position: Int) {
        val listaAlumno= alumnos[position]
        holder.foto.setImageResource(listaAlumno.foto)
        holder.txtNombre.text= listaAlumno.nombre
        holder.btnPromedio.setOnClickListener {
            val promedio = holder.edtPromedio.text.toString().toFloat()
            modelo.modificarBeca(1, promedio) { estado, mensaje ->
                if (estado)
                {
                    //mandar a la pantalla de todos los alumnos
                }
            }
        }
    }

    override fun getItemCount(): Int { //Cunatos elementos hay en la lista
        return alumnos.size
    }

    //Creamos mi Holder (Indica que va a trabajar con el Recycler y va a estar tomando los item o posiciones)
    class misControles(item: View): RecyclerView.ViewHolder(item){


        //Referencias de datos.xml
        val foto: ImageView = item.findViewById(R.id.imgFoto)
        val txtNombre: TextView= item.findViewById(R.id.txtNombre)
        val edtPromedio: TextView= item.findViewById(R.id.edtPromedio)

        val btnPromedio : Button = item.findViewById(R.id.btnCalcularPromedio)

    }
}