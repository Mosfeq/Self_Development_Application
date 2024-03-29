package com.mosfeq.selfdevelopmentapp

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.home_fragment.*
import java.text.SimpleDateFormat
import java.util.*

class HomeFragment: Fragment(R.layout.home_fragment), HabitAdapter.onItemClickListener {

    val habitsList = arrayListOf<HabitItem>()
    val adapter = HabitAdapter(habitsList, this)
    private lateinit var database: DatabaseReference

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(context)
        recycler_view.setHasFixedSize(true)

        retrieveUserData()

        btn_addHabit.setOnClickListener {
            addHabitPage()
        }

        btn_deleteHabit.setOnClickListener {
            val habitToBeDeleted = et_enterHabitToDelete.text.toString()
            if (habitToBeDeleted.isNotEmpty()){
                deleteHabit(habitToBeDeleted)
            }else{
                Toast.makeText(context, "Please enter habit to be deleted", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun addHabitPage(){
        val action = HomeFragmentDirections.actionHomeFragmentToAddHabitsFragment()
        findNavController().navigate(action)
    }

    override fun habitClicked(position: Int) {
        database = FirebaseDatabase.getInstance("https://self-improvement-application-default-rtdb.europe-west1.firebasedatabase.app/").getReference("Habits")

        val sdf = SimpleDateFormat("dd/M/yyyy")
        val currentDate = sdf.format(Date())
        val clickedHabit = habitsList[position]
        val nameOfHabit = clickedHabit.habitName
        val numberOfHabitClicks = clickedHabit.numberOfClicks

        clickedHabit.numberOfClicks = clickedHabit.numberOfClicks + 1
        clickedHabit.lastDateDoingHabit = currentDate
        adapter.notifyItemChanged(position)

        val updateLastDate = mapOf<String,String>(
            "lastDayDoingHabit" to currentDate,
        )

        val updateNumberOfClicks = mapOf(
            "numberOfClicks" to numberOfHabitClicks
        )

        database.child(nameOfHabit).updateChildren(updateLastDate).addOnSuccessListener {

            Toast.makeText(context, "Updated date", Toast.LENGTH_SHORT).show()

        }.addOnFailureListener {

            Toast.makeText(context, "Date not updated", Toast.LENGTH_SHORT).show()

        }

        database.child(nameOfHabit).updateChildren(updateNumberOfClicks).addOnSuccessListener {

            Log.e("Clicks", "Done")

        }.addOnFailureListener {

            Log.e("Clicks", "Not Done")

        }
    }

    private fun retrieveUserData(){
        database = FirebaseDatabase.getInstance("https://self-improvement-application-default-rtdb.europe-west1.firebasedatabase.app/").getReference("Habits")

        database.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {

                if (snapshot.exists()){

                    for (habitSnapshot in snapshot.children){

                        val habit = habitSnapshot.getValue(HabitItem::class.java)
                        if (habit != null) {
                            habitsList.add(0, habit)
                        }
                        adapter.notifyItemInserted(0)

                    }
                }
            }
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "Habit Not Here", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun deleteHabit(deleteHabit: String){
        database = FirebaseDatabase.getInstance("https://self-improvement-application-default-rtdb.europe-west1.firebasedatabase.app/").getReference("Habits")
        database.child(deleteHabit).removeValue().addOnSuccessListener {
            et_enterHabitToDelete.text.clear()
            Toast.makeText(context, "Successfully Deleted", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener {
            Toast.makeText(context, "Habit not Deleted", Toast.LENGTH_SHORT).show()
        }
        habitsList.removeAt(0)
        adapter.notifyItemRemoved(0)
    }
}