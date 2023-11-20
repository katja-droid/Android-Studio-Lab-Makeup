package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.ItemListBinding

class RecipeAdapter(
    val onClick: (recipe: Recipe, position: Int) -> Unit
) : RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {

    private val list = ArrayList<Recipe>()

    fun setList(newList: List<Recipe>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    inner class RecipeViewHolder(val binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(element: Recipe, position: Int) {

            binding.tvName.text = element.name
            val str = binding.tvDesc.context.getString(R.string.description) + element.shade
            binding.tvDesc.text = str
            binding.btn.setOnClickListener {
                onClick(element, position)
            }


            Glide.with(binding.iv.context)
                .load("https://lh3.googleusercontent.com/MwDSfjPZi7R6hCkXsm1sv8OrJnlmqjEsar0MI6RvoTKVA_AvEm3cmS-i6MIuzYu2w9aIH-sd6D0gy9kEkHo_-_IoKlaHlPhE4e528z6dhCXKW6E=e365-rj-l80-w364")
                .centerInside()
                .into(binding.iv)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecipeViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val element = list[position]
        holder.bind(element, position)
    }
}