package com.mosfeq.selfdevelopmentapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.habit_item.view.*

class HabitAdapter(
    private val listOfHabits: List<HabitItem>,
//    private val clickListener: onItemClickListener
    ) : RecyclerView.Adapter<HabitAdapter.HabitViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HabitViewHolder {
        val objectView = LayoutInflater.from(parent.context).
        inflate(R.layout.habit_item, parent, false)

        return HabitViewHolder(objectView)
    }

    override fun onBindViewHolder(holder: HabitViewHolder, position: Int) {
        val currentHabitItem = listOfHabits[position]

        holder.habitName.text = currentHabitItem.habitName
        holder.goalText.text = currentHabitItem.goalText
        holder.reason.text = currentHabitItem.reason
    }

    override fun getItemCount(): Int {
        return listOfHabits.size
    }

    class HabitViewHolder(objectView: View): RecyclerView.ViewHolder(objectView){
        val habitName: TextView = objectView.tv_habitName
        val goalText: TextView = objectView.tv_goalText
        val reason: TextView = objectView.tv_reason

//        init {
//            itemView.setOnClickListener(this)
//        }
//
//        override fun onClick(v: View?) {
//            val position: Int = absoluteAdapterPosition
//            if (position != RecyclerView.NO_POSITION){
//                clickListener.habitClicked(position)
//            }
//        }
    }

//    interface onItemClickListener{
//        fun habitClicked(position: Int)
//    }

}