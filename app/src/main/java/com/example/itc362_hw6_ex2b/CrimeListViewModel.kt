package com.example.itc362_hw6_ex2b

import androidx.lifecycle.ViewModel
import java.util.*

class CrimeListViewModel : ViewModel() {

    val crimes = mutableListOf<Crime>()

    init {
        for (i in 0 until 100) {
            val crime = Crime(
                id = UUID.randomUUID(),
                title ="Crime #$i",
                date = Date(),
                isSolved = i % 2 == 0,
                requirePolice = i % 2 == 0
            )

            crimes += crime
        }
    }
}