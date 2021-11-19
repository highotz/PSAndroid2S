package com.example.psandroid2s.ui.signin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.psandroid2s.R
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignInFragment : Fragment() {

    companion object {
        fun newInstance() = SignInFragment()
    }

    private lateinit var viewModel: SignInViewModel
    private var REQUEST_CODE = 1001
    private val providers = arrayListOf(
        AuthUI.IdpConfig.EmailBuilder().build(),
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.sign_in_fragment, container, false)

        startActivityForResult(
            AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(providers)
                .build(),
            REQUEST_CODE
        )

        return view
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == REQUEST_CODE){
            val response = IdpResponse.fromResultIntent(data)

            if(resultCode == Activity.RESULT_OK){
                val firebaseUser = Firebase.auth.currentUser
                Log.i("FirebaseUIResult", "${firebaseUser?.email}")
                Toast.makeText(requireActivity().applicationContext, "Falha no Login!", Toast.LENGTH_LONG).show()
            }else  {
                Toast.makeText(requireActivity().applicationContext, "Falha no Login!", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SignInViewModel::class.java)
        // TODO: Use the ViewModel
    }

}