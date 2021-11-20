package com.example.psandroid2s.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.psandroid2s.api.RelatorioApi
import com.example.psandroid2s.api.RetrofitBuilder
import com.example.psandroid2s.data.MedicoesRepository
import com.example.psandroid2s.ui.listall.ListAllViewModel

object ViewModelFactory : ViewModelProvider.NewInstanceFactory() {

    private val retrofit = RetrofitBuilder.retrofit

    private val relatorioApi = RelatorioApi(retrofit)

    private val medicoesRepository = MedicoesRepository(relatorioApi)


    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return   ListAllViewModel(medicoesRepository) as T

    }
}