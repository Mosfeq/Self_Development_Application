package com.mosfeq.selfdevelopmentapp

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.home_fragment.*

class HomeFragment : Fragment(R.layout.home_fragment) {

    private val args: HomeFragmentArgs by navArgs()
    private val habitsList = listGenerator(20)
    private val adapter = HabitAdapter(habitsList)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(context)
        recycler_view.setHasFixedSize(true)

        btn_addHabit.setOnClickListener {
            addHabitPage(view)
        }

        btn_deleteHabit.setOnClickListener {
            deleteHabit(view)
        }

        btn_Refresh.setOnClickListener{
            val index: Int = 0
            val habitName = args.habitName
            val lastFirstDate = args.lastFirstDay
            val reason = args.reason
            Log.d("ARGS","$habitName, $lastFirstDate, $reason")

            val newHabit = HabitItem(habitName, "Last day: $lastFirstDate", "Reason: $reason")

            habitsList.add(index, newHabit)
            adapter.notifyItemInserted(index)
        }
    }

//    override fun habitClicked(position: Int) {
//        val action = HomeFragmentDirections.actionHomeFragmentToHabitsSettingsFragment()
//        findNavController().navigate(action)
//    }

    private fun addHabitPage(view: View) {
        val action = HomeFragmentDirections.actionHomeFragmentToAddHabitsFragment()
        findNavController().navigate(action)
    }

//    private fun addHabit(){
//        val index: Int = 0
//        val habitName = args.habitName
//        val lastFirstDate = args.lastFirstDay
//        val reason = args.reason
//        Log.d("ARGS","$habitName, $lastFirstDate, $reason")
//
//        val newHabit = HabitItem(habitName, "Last day: $lastFirstDate", "Reason: $reason")
//
//        habitsList.add(index, newHabit)
//        adapter.notifyItemInserted(index)
//    }

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