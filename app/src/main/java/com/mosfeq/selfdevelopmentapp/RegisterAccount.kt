package com.mosfeq.selfdevelopmentapp

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.register_account.*


class RegisterAccount : Fragment(R.layout.register_account) {

    private lateinit var auth: FirebaseAuth

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = FirebaseAuth.getInstance()
        et_createUsername.text.clear()
        et_createPassword.text.clear()
        et_createConfirmPassword.text.clear()

        btn_confirmRegister.setOnClickListener {

            if(et_createUsername.text.trim().isNotEmpty() && et_createPassword.text.trim().isNotEmpty() && et_createConfirmPassword.text.trim().isNotEmpty()){
                if(et_createPassword.text.toString() == et_createConfirmPassword.text.toString()){
                    registerUser()
                }else{
                    Toast.makeText(context, "Password does not match", Toast.LENGTH_SHORT).show()
                    Log.e("Match", "CP = $et_createPassword, CCP = $et_createConfirmPassword")
                }
            }else{
                Toast.makeText(context,"Information required", Toast.LENGTH_SHORT).show()
            }

        }

        tv_changeToLoginPage.setOnClickListener {
            val action = RegisterAccountDirections.actionRegisterAccountToLoginAccount()
            findNavController().navigate(action)
        }

    }

    private fun registerUser(){
        auth.createUserWithEmailAndPassword(et_createUsername.text.trim().toString(), et_createPassword.text.trim().toString())
            .addOnCompleteListener{
                    task ->
                if (task.isSuccessful){
                    Toast.makeText(context,"Register Successful",Toast.LENGTH_SHORT).show()
                    val action = RegisterAccountDirections.actionRegisterAccountToHomeFragment()
                    findNavController().navigate(action)
                }else{
                    Toast.makeText(context,"Register Failed"+task.exception,Toast.LENGTH_SHORT).show()
                    Log.e("RegisterActivity", "Failed: ${task.exception}")
                }
            }
    }

}