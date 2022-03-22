package com.mosfeq.selfdevelopmentapp

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.delete_habits_fragment.*
import kotlinx.android.synthetic.main.home_fragment.*

class DeleteHabitsFragment: Fragment(R.layout.delete_habits_fragment) {

    private lateinit var database: DatabaseReference

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_deleteDone.setOnClickListener {
            val habitToBeDeleted = et_deleteHabit.text.toString()
            if (habitToBeDeleted.isNotEmpty()){
                deleteHabit(habitToBeDeleted)
            }else{
                Toast.makeText(context, "Please enter habit to be deleted", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun deleteHabit(deleteHabit: String){
        database = FirebaseDatabase.getInstance("https://self-improvement-application-default-rtdb.europe-west1.firebasedatabase.app/").getReference("Habits")
        database.child(deleteHabit).removeValue().addOnSuccessListener {
            et_deleteHabit.text.clear()
            Toast.makeText(context, "Successfully Deleted", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener {
            Toast.makeText(context, "Habit not Deleted", Toast.LENGTH_SHORT).show()
        }
    }

}