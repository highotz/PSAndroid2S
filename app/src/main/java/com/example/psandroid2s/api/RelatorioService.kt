package com.example.psandroid2s.api

import com.example.psandroid2s.model.ReturnRelatorio
import retrofit2.http.GET
import retrofit2.http.Path

interface RelatorioService {

    @GET("/medicao")
    suspend fun getAll(): List<ReturnRelatorio>
}