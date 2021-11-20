package com.example.psandroid2s.data

import com.example.psandroid2s.api.RelatorioApi

class MedicoesRepository(private val api: RelatorioApi) {

    fun getAll() = api.getAll()

}