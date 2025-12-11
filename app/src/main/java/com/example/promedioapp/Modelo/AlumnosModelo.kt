package com.example.promedioapp.Modelo
import com.example.promedioapp.R

class AlumnosModelo {
    lateinit var alumnos: List<AlumnosDatos>
    fun calcularTipoBeca(promedio: Float): String
    {
        return  when {
            promedio >= 9 -> "Beca de Excelencia"
            promedio >=8 -> "Beca de Servicio"
            else -> "Beca de Alimentación"
        }
    }
    fun calcualarMontoBeca (promedio: Float): String{

        return  when {
            promedio >= 9 -> "$ 3500.00 Pesos"
            promedio >= 8 -> "$ 2800.00 Pesos"
            else -> "$ 1500.00 Pesos"
        }
    }

    fun cargarDatos (): List<AlumnosDatos>
    {
       alumnos= mutableListOf(
           AlumnosDatos("Luis",8.9f, "", "", R.drawable.perfil),
           AlumnosDatos("Juanita",9.0f, "", "", R.drawable.perfildos),
           AlumnosDatos("David",10f, "", "", R.drawable.perfiltres),
           AlumnosDatos("Angel",7.0f, "", "", R.drawable.foto4),
           AlumnosDatos("Maria",4.0f, "", "", R.drawable.foto5),
           AlumnosDatos("Juan jose",10f, "", "", R.drawable.foto6),
           AlumnosDatos("Danna",9.0f, "", "", R.drawable.foto7),
           AlumnosDatos("Jennifer",6.0f, "", "", R.drawable.foto8),
           AlumnosDatos("Jesus",10f, "", "", R.drawable.foto9),
           AlumnosDatos("Valeria",5.0f, "", "", R.drawable.foto10),
       )

        alumnos.forEach {
            it.tipoBeca = calcularTipoBeca(it.promedio);
            it.montoBeca= calcualarMontoBeca(it.promedio)
        }
        return alumnos
    }
}