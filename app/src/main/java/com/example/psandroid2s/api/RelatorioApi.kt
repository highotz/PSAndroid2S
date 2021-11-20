package com.example.psandroid2s.api

import com.example.psandroid2s.model.ReturnRelatorio
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import retrofit2.Retrofit

class RelatorioApi(private val retrofit: Retrofit) {

    private val service: RelatorioService by lazy {
        retrofit.create(RelatorioService::class.java)
    }

    fun getAll(): Flow<List<ReturnRelatorio>> {
        return channelFlow {
            send(service.getAll())
        }
    }


}