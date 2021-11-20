package com.example.psandroid2s.ui.listall

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.GeneratedAdapter
import androidx.lifecycle.ViewModelProvider
import com.example.psandroid2s.R
import com.example.psandroid2s.factory.ViewModelFactory
import com.example.psandroid2s.model.Local
import com.example.psandroid2s.model.ReturnRelatorio
import kotlin.math.log

class ListAllFragment : Fragment() {

    //private lateinit var adapter: GuarulhosListAdapter

    private val viewModel: ListAllViewModel by lazy {
        ViewModelProvider(this,
            ViewModelFactory
        ).get(
            ListAllViewModel::class.java)
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.list_all_fragment, container, false)

        viewModel.getAll()
        viewModel.listMedicoes.observe(viewLifecycleOwner){
            it.forEach { Log.e("ListaAll", it.id )}

        }
        return view
    }

}