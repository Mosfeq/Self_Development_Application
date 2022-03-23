package com.mosfeq.selfdevelopmentapp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.login_register_account.*


class LoginRegisterAccount : Fragment(R.layout.login_register_account) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_login.setOnClickListener {
            val action = LoginRegisterAccountDirections.actionLoginRegisterAccountToLoginAccount()
            findNavController().navigate(action)
        }

        btn_createAccount.setOnClickListener {
            val action = LoginRegisterAccountDirections.actionLoginRegisterAccountToRegisterAccount()
            findNavController().navigate(action)
        }
    }
}