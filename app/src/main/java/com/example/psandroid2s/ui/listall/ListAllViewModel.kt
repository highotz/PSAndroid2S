package com.example.psandroid2s.ui.listall

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.psandroid2s.data.MedicoesRepository
import com.example.psandroid2s.model.ReturnRelatorio
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ListAllViewModel(private val repository: MedicoesRepository) : ViewModel() {
    // TODO: Implement the ViewModel

    private var _listMedicoes = MutableLiveData<List<ReturnRelatorio>>()
    val listMedicoes: LiveData<List<ReturnRelatorio>> get() = _listMedicoes

    fun getAll() {
        viewModelScope.launch {
            repository.getAll().collect {
                _listMedicoes.value = it
            }
        }
    }


}