package com.mosfeq.selfdevelopmentapp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.habits_settings_fragment.*

class HabitsSettingsFragment: Fragment(R.layout.habits_settings_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_settingsDone.setOnClickListener{
            val action = HabitsSettingsFragmentDirections.actionHabitsSettingsFragmentToHomeFragment()
            findNavController().navigate(action)
        }
    }
}