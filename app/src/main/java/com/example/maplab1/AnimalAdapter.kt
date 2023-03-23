package com.example.maplab1

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.maplab1.databinding.AnimalCardBinding

class AnimalAdapter(
    val onClick: (model: Animal, position: Int) -> Unit
) : RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {
    private val list = ArrayList<Animal>()

    inner class AnimalViewHolder(val binding: AnimalCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindView(animal: Animal, position: Int) {
            binding.tvName.text = animal.name
            binding.tvDesc.text = animal.description
//            binding.iv.setImageResource(getResources().getIdentifier(animal.imageName,"drawable","com.app"))
//            binding.iv.setImageUrl(animal.imagePath)
//            val imgId = binding.iv.context.getDrawable(animal.imageId)
            binding.iv.setImageDrawable(binding.iv.context.getDrawable(animal.imageId))
            binding.iv.setColorFilter(Color.parseColor(animal.relatedColor1))
            binding.btn.setBackgroundColor(Color.parseColor(animal.relatedColor2))
            binding.btn.setOnClickListener {
                onClick(animal, position)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val view = AnimalCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AnimalViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        val animal = list[position]
        holder.bindView(animal, position)
    }

    fun setNewData(newList: List<Animal>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }
}