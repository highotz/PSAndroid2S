package com.example.psandroid2s.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    val retrofit = Retrofit.Builder()
        .baseUrl("http://10.0.2.2:3000/") // esse ip é só para rodar o app no emulador
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}