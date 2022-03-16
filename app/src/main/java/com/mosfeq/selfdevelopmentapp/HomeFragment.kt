package com.mosfeq.selfdevelopmentapp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.home_fragment.*
import kotlinx.android.synthetic.main.login_create_account_fragment.*

class HomeFragment : Fragment(R.layout.home_fragment) {

    private val habitsList = listGenerator(20)
    private val adapter = HabitAdapter(habitsList)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(context)
        recycler_view.setHasFixedSize(true)

        btn_addHabit.setOnClickListener {
            addHabit(view)
        }

        btn_deleteHabit.setOnClickListener {
            deleteHabit(view)
        }
    }

    private fun addHabit(view: View){
        val index: Int = 0

        val newHabit = HabitItem(
            "Habit Name",
            "goal: $index",
            "reason:"
        )
        habitsList.add(index, newHabit)
        adapter.notifyItemInserted(index)
    }

    private fun deleteHabit(view: View){
        val index: Int = 0
        habitsList.removeAt(index)
        adapter.notifyItemRemoved(index)
    }

    private fun listGenerator(sizeOfList: Int): ArrayList<HabitItem>{
        val list = ArrayList<HabitItem>()

        for (i in 0 until sizeOfList){
            val habitItem = HabitItem("Habit Name $i", "Last Date: ", "Reason: ")
            list+= habitItem
        }
        return list
    }
}