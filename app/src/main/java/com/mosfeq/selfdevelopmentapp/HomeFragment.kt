package com.mosfeq.selfdevelopmentapp

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.home_fragment.*

class HomeFragment: Fragment(R.layout.home_fragment) {

    private val habitsList = arrayListOf<HabitItem>()
    private val adapter = HabitAdapter(habitsList)
    private lateinit var database: DatabaseReference

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(context)
        recycler_view.setHasFixedSize(true)

        btn_addHabit.setOnClickListener {
            addHabitPage()
        }

        btn_deleteHabit.setOnClickListener {
            deleteHabit(view)
        }

        retrieveUserData()
    }

    private fun addHabitPage(){
        val action = HomeFragmentDirections.actionHomeFragmentToAddHabitsFragment()
        findNavController().navigate(action)
    }

    //    override fun habitClicked(position: Int) {
//        val action = HomeFragmentDirections.actionHomeFragmentToHabitsSettingsFragment()
//        findNavController().navigate(action)
//    }

//                val habit = it.child("habitName").value.toString()
//                val goal = it.child("goal").value.toString()
//                val reason = it.child("reason").value.toString()


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

    private fun deleteHabit(view: View){
        val index: Int = 0
        habitsList.removeAt(index)
        adapter.notifyItemRemoved(index)
    }

//    private fun listGenerator(sizeOfList: Int): ArrayList<HabitItem>{
//        val list = ArrayList<HabitItem>()
//
//        for (i in 0 until sizeOfList){
//            val habitItem = HabitItem("Habit Name", "Goal: ", "Reason: ")
//            list+= habitItem
//        }
//        return list
//    }

}