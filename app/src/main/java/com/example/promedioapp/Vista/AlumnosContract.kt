package com.example.promedioapp.Vista

import com.example.promedioapp.Modelo.AlumnosDatos
import com.example.promedioapp.Modelo.clsRespuestaAlumnos

interface AlumnosContract {

    fun mostrarAlumnos( alumnos : List<AlumnosDatos>)
    //fun mostrarAlumnosCompletos( alumnos : List<clsRespuestaAlumnos>)

}