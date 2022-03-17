package com.mosfeq.selfdevelopmentapp

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.add_habits_fragment.*
import kotlinx.android.synthetic.main.home_fragment.*
import java.util.*

class AddHabitsFragment: Fragment(R.layout.add_habits_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val enterHabitName = et_addEnterHabit.text.toString()
        val enterLastFirstDay = et_addEnterLastFirstDay.text.toString()
        val enterGoal = et_addEnterGoal.text.toString()
        val enterReason = et_addEnterReason.text.toString()

        btn_addDone.setOnClickListener{
            val action = AddHabitsFragmentDirections.actionAddHabitsFragmentToHomeFragment(
                enterHabitName, enterLastFirstDay, enterReason)
            findNavController().navigate(action)
        }
    }
}