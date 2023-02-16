package com.mosfeq.selfdevelopmentapp

data class HabitItem(
    var habitName: String = "",
    var goal: String? = null,
    var reason: String? = null,
    var lastDateDoingHabit: String? = null,
    var numberOfClicks: Int = 0) {
}