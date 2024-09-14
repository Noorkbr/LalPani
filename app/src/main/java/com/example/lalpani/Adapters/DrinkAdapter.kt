package com.example.lalpani.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lalpani.DomainLayer.Drink
import com.example.lalpani.databinding.ItemDrinkBinding

class DrinkAdapter(private   val drinks: List<Drink?>
) : RecyclerView.Adapter<DrinkAdapter.DrinkViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinkAdapter.DrinkViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemDrinkBinding.inflate(inflater, parent, false) // Inflate using DataBinding
        return DrinkViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DrinkAdapter.DrinkViewHolder, position: Int) {
        drinks[position].let {
            holder.binding.apply {
                mealName.text = it?.name
            }
            Glide.with(holder.itemView.context).load(it?.imageUrl).into(holder.binding.mealImage)
        }


    }

    override fun getItemCount(): Int {
        return drinks.size
    }
    inner class DrinkViewHolder(val binding: ItemDrinkBinding):
            RecyclerView.ViewHolder(binding.root)
}