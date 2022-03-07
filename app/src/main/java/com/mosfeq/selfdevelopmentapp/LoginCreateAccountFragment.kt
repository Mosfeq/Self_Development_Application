package com.mosfeq.selfdevelopmentapp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.login_create_account_fragment.*

class LoginCreateAccountFragment : Fragment(R.layout.login_create_account_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_login.setOnClickListener{
            val action = LoginCreateAccountFragmentDirections.actionLoginCreateAccountFragmentToLoginFragment()
            findNavController().navigate(action)
        }
    }

}