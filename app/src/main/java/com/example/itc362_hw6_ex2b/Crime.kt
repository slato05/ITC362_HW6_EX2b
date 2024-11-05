package com.example.itc362_hw6_ex2b

import java.util.*

data class Crime(
    val id: UUID,
    val title: String,
    val date: Date,
    val isSolved: Boolean,
    var requirePolice : Boolean = false
)