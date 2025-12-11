package com.example.promedioapp.Modelo
import com.example.promedioapp.R
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AlumnosModelo {
    private lateinit var apiService: ifaceApiService

    fun inicializarApiService() {
        //Configuracion de Retrofit
        val retrofit = Retrofit.Builder()
            .baseUrl("https://grupoctic.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient())
            .build()

        apiService = retrofit.create(ifaceApiService::class.java)
    }

    fun modificarBeca(id : Int, promedio : Float, callback: (Boolean, String) -> Unit)
    {
        inicializarApiService()
        apiService.modificarBeca(id, promedio).enqueue(object: Callback<List<clsRespuesta>>
        {
            override fun onResponse(call: Call<List<clsRespuesta>>, response: Response<List<clsRespuesta>>)
            {
                if (response.isSuccessful)
                {
                    response.body()?.let { respuesta ->
                        callback(respuesta[0].estado, respuesta[0].salida)
                    }
                }
                else
                {
                    callback(false, "Error: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<List<clsRespuesta>?>, t: Throwable) {
                callback(false, "Error: ${t.message}")
            }
        })
    }

    fun recuperarAlumnos(callback: (Boolean, String, List<clsRespuestaAlumnos>) -> Unit)
    {
        inicializarApiService()
        apiService.obtenerAlumnos().enqueue(object: Callback<List<clsRespuestaAlumnos>>
        {
            override fun onResponse(call: Call<List<clsRespuestaAlumnos>>, response: Response<List<clsRespuestaAlumnos>>)
            {
                if (response.isSuccessful)
                {
                    response.body()?.let { alumnos ->
                        callback(true, "Alumnos recuperados de manera exitosa", alumnos)
                    }
                }
                else
                {
                    callback(false, "Error: ${response.message()}", emptyList())
                }
            }

            override fun onFailure(call: Call<List<clsRespuestaAlumnos>?>, t: Throwable) {
                callback(false, "Error: ${t.message}", emptyList())
            }
        })
    }
}