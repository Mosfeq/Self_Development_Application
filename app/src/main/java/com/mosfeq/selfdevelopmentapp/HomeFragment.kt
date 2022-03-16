package com.mosfeq.selfdevelopmentapp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.home_fragment.*
import kotlinx.android.synthetic.main.login_create_account_fragment.*

class HomeFragment : Fragment(R.layout.home_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler_view.adapter = HabitAdapter(listGenerator(20))
        recycler_view.layoutManager = LinearLayoutManager(context)
        recycler_view.setHasFixedSize(true)
    }

    private fun listGenerator(sizeOfList: Int): List<HabitItem>{
        val habitsList = ArrayList<HabitItem>()

        for (i in 0 until sizeOfList){
            val habitItem = HabitItem("Habit Name $i", "Last Date: ", "Reason: ")
            habitsList+= habitItem
        }
        return habitsList
    }

}