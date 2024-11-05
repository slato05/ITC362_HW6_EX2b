package com.example.itc362_hw6_ex2b

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.itc362_hw6_ex2b.databinding.ItemListCrimeBinding
import com.example.itc362_hw6_ex2b.databinding.ItemListSeriousCrimeBinding


class NormalCrimeHolder(private val binding: ItemListCrimeBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(crime: Crime) {
        binding.crimeTitle.text = crime.title
        binding.crimeDate.text = crime.date.toString()

        binding.root.setOnClickListener {
            Toast.makeText(
                binding.root.context,
                "${crime.title} clicked!",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}

class SeriousCrimeHolder(private val binding: ItemListSeriousCrimeBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(crime: Crime) {
        binding.crimeTitle.text = crime.title
        binding.crimeDate.text = crime.date.toString()

        binding.root.setOnClickListener {
            Toast.makeText(
                binding.root.context,
                "${crime.title} clicked!",
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.contactPoliceButton.setOnClickListener {
            Toast.makeText(
                binding.root.context,
                "Police contacted!",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}

class CrimeListAdapter(private val crimes: List<Crime>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val VIEW_TYPE_NORMAL = 0
        private const val VIEW_TYPE_SERIOUS = 1
    }

    override fun getItemViewType(position: Int): Int {
        return if (crimes[position].requirePolice) VIEW_TYPE_SERIOUS else VIEW_TYPE_NORMAL
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_SERIOUS -> {
                val inflater = LayoutInflater.from(parent.context)
                val view = ItemListSeriousCrimeBinding.inflate(inflater, parent, false)
                SeriousCrimeHolder(view)
            }
            else -> {
                val inflater = LayoutInflater.from(parent.context)
                val view = ItemListCrimeBinding.inflate(inflater, parent, false)
                NormalCrimeHolder(view)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val crime = crimes[position]
        when (holder) {
            is SeriousCrimeHolder -> holder.bind(crime)
            is NormalCrimeHolder -> holder.bind(crime)
        }
    }

    override fun getItemCount() = crimes.size
}