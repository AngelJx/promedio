package com.example.promedioapp.Vista

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.promedioapp.Modelo.AlumnosModelo
import com.example.promedioapp.R

class Alumnos : AppCompatActivity() {
    lateinit var rcvListaAlumnos : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_alumnos)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        rcvListaAlumnos = findViewById(R.id.rcvListaAlumnos)
        rcvListaAlumnos.layoutManager= LinearLayoutManager(this)

        //el presentador va a ejecutar la función mostrarAlumnosCompletos
    }

    val model = AlumnosModelo()

    fun mostrarAlumnosCompletos()
    {
        model.recuperarAlumnos { estado, mensaje, alumnos ->
            if (estado)
            {
                rcvListaAlumnos.adapter = AlumnosCompletosAdapter(this@Alumnos, alumnos)
            }
        }
    }
}