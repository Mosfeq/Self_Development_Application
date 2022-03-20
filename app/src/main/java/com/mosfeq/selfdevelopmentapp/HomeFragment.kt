package com.mosfeq.selfdevelopmentapp

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.add_habits_fragment.*
import kotlinx.android.synthetic.main.home_fragment.*

class HomeFragment : Fragment(R.layout.home_fragment) {

    private val habitsList = listGenerator(20)
    private val adapter = HabitAdapter(habitsList)
    private lateinit var database: DatabaseReference

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(context)
        recycler_view.setHasFixedSize(true)

        database = FirebaseDatabase.getInstance("https://self-improvement-application-default-rtdb.europe-west1.firebasedatabase.app/").getReference("Habits")
        database.child("Habits").get().addOnSuccessListener {
            if (it.exists()){
                val habit = it.child("habitName").value.toString()
                val goal = it.child("goalText").value.toString()
                val reason = it.child("reason").value.toString()
                val newHabit = HabitItem(habit, "Goal: $goal", "Reason: $reason")
                val index: Int = 0
                habitsList.add(index, newHabit)
                adapter.notifyItemInserted(index)

                Toast.makeText(context, "Habit Exists", Toast.LENGTH_SHORT).show()

            }else{
                Toast.makeText(context, "Habit not here", Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
        }

        btn_addHabit.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToAddHabitsFragment()
            findNavController().navigate(action)
        }

        btn_deleteHabit.setOnClickListener {
            deleteHabit(view)
        }
    }

//    override fun habitClicked(position: Int) {
//        val action = HomeFragmentDirections.actionHomeFragmentToHabitsSettingsFragment()
//        findNavController().navigate(action)
//    }

//    private fun addHabit(){
//
//    }

    private fun deleteHabit(view: View){
        val index: Int = 0
        habitsList.removeAt(index)
        adapter.notifyItemRemoved(index)
    }

    private fun listGenerator(sizeOfList: Int): ArrayList<HabitItem>{
        val list = ArrayList<HabitItem>()

        for (i in 0 until sizeOfList){
            val habitItem = HabitItem("Habit Name", "Goal: ", "Reason: ")
            list+= habitItem
        }
        return list
    }
}
