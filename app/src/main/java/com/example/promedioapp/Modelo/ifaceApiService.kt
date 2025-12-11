package com.example.promedioapp.Modelo

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ifaceApiService {
    @FormUrlEncoded
    @POST("apiAlumnos.php")
    fun modificarBeca(
        @Field("id") id : Int,
        @Field("promedio") promedio : Float
    ): Call<List<clsRespuesta>>

    @GET("apiRecuperarAlumnos.php")
    fun obtenerAlumnos(): Call<List<clsRespuestaAlumnos>>
}