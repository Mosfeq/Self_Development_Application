package com.mosfeq.selfdevelopmentapp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.home_fragment.*
import kotlinx.android.synthetic.main.login_create_account_fragment.*

class HomeFragment : Fragment(R.layout.home_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_LoginDone.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToLoginCreateAccountFragment()
            findNavController().navigate(action)
        }

    }

}