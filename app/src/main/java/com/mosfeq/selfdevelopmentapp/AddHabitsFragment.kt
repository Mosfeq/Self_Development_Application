package com.mosfeq.selfdevelopmentapp

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.add_habits_fragment.*

class AddHabitsFragment : Fragment(R.layout.add_habits_fragment) {

    private lateinit var database: DatabaseReference

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val habitName = et_addEnterHabit.text.toString().trim()
        val goal = et_addEnterGoal.text.toString().trim()
        val reason = et_addEnterReason.text.toString().trim()

        database = FirebaseDatabase.getInstance("https://self-improvement-application-default-rtdb.europe-west1.firebasedatabase.app/").getReference("Habits")
        val habitItem = HabitItem(habitName, goal, reason)

        database.child(habitName).setValue(habitItem).addOnCompleteListener {
            Toast.makeText(context, "Habit Added", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener {
            Toast.makeText(context, "Habit Not Added", Toast.LENGTH_SHORT).show()
        }
    }
}