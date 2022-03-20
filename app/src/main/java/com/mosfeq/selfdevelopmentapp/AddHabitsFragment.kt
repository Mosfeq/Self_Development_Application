package com.mosfeq.selfdevelopmentapp

import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.add_habits_fragment.*

open class AddHabitsFragment : Fragment(R.layout.add_habits_fragment) {

    private lateinit var database: DatabaseReference

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_addDone.setOnClickListener {
            val inputtedHabit = et_enterHabit.text.toString()
            val inputtedGoal = et_enterGoal.text.toString()
            val inputtedReason = et_enterReason.text.toString()

            println("$inputtedHabit, $inputtedGoal, $inputtedReason")

            database = FirebaseDatabase.getInstance("https://self-improvement-application-default-rtdb.europe-west1.firebasedatabase.app/").getReference("Habits")
            val habitItem = HabitItem(inputtedHabit, inputtedGoal, inputtedReason)

            database.child(inputtedHabit).setValue(habitItem).addOnCompleteListener {
                Toast.makeText(context, "Habit Added", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener {
                Toast.makeText(context, "Habit Not Added", Toast.LENGTH_SHORT).show()
            }

            val action = AddHabitsFragmentDirections.actionAddHabitsFragmentToHomeFragment()
            findNavController().navigate(action)

        }
    }
}