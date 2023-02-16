package com.mosfeq.selfdevelopmentapp

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.login_account.*

class LoginAccount : Fragment(R.layout.login_account) {

    private lateinit var auth: FirebaseAuth

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = FirebaseAuth.getInstance()
        et_enterEmail.text.clear()
        et_enterPassword.text.clear()

        btn_confirmLogin.setOnClickListener {
            if (et_enterEmail.text.trim().isNotEmpty() && et_enterPassword.text.trim().isNotEmpty()){
                signInUser()
            }else{
                Toast.makeText(context,"Information required", Toast.LENGTH_SHORT).show()
            }
        }

        tv_changeToRegisterPage.setOnClickListener {
            val action = LoginAccountDirections.actionLoginAccountToRegisterAccount()
            findNavController().navigate(action)
        }

    }

    private fun signInUser(){
        auth.signInWithEmailAndPassword(et_enterEmail.text.trim().toString(), et_enterPassword.text.trim().toString())
            .addOnCompleteListener{
                    task ->
                if(task.isSuccessful){
                    Toast.makeText(context,"Login Successful",Toast.LENGTH_SHORT).show()
                    val action = LoginAccountDirections.actionLoginAccountToHomeFragment()
                    findNavController().navigate(action)
                }else{
                    Toast.makeText(context,"Authentication Error"+task.exception,Toast.LENGTH_SHORT).show()
                }
            }
    }

}