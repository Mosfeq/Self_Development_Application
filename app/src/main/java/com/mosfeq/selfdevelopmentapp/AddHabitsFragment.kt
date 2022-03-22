package com.mosfeq.selfdevelopmentapp

import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.add_habits_fragment.*
import kotlinx.android.synthetic.main.home_fragment.*

open class AddHabitsFragment : Fragment(R.layout.add_habits_fragment) {

    private lateinit var database: DatabaseReference

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_addDone.setOnClickListener {

            addHabit()

            val action = AddHabitsFragmentDirections.actionAddHabitsFragmentToHomeFragment()
            findNavController().navigate(action)

        }
    }

    fun addHabit(){
        database = FirebaseDatabase.getInstance("https://self-improvement-application-default-rtdb.europe-west1.firebasedatabase.app/").getReference("Habits")

        val inputtedHabit = et_enterHabit.text.toString()
        val inputtedLastDayHabit = et_enterLastDayHabit.text.toString()
        val inputtedGoal = et_enterGoal.text.toString()
        val inputtedReason = et_enterReason.text.toString()

        val habitItem = HabitItem(inputtedHabit ,inputtedGoal, inputtedReason, inputtedLastDayHabit, 0)

        database.child(inputtedHabit).setValue(habitItem).addOnCompleteListener {
            Toast.makeText(context, "Habit Added", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener {
            Toast.makeText(context, "Habit Not Added", Toast.LENGTH_SHORT).show()
        }
    }
}