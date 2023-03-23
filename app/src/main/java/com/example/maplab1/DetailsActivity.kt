package com.example.maplab1

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.maplab1.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val animal = intent.getParcelableExtra<Animal>(MainActivity.MY_ANIMAL_KEY)
        animal?.let {
            binding.tvName.text = animal.name
            binding.tvDesc.text = animal.description
//            binding.iv.setImageResource(getResources().getIdentifier(animal.imageName,"drawable","com.app"))
            binding.iv.setImageDrawable(binding.iv.context.getDrawable(animal.imageId))
            binding.iv.setColorFilter(Color.parseColor(animal.relatedColor1))
            binding.btnBack.setBackgroundColor(Color.parseColor(animal.relatedColor2))
            binding.btnBack.setOnClickListener {
                startActivity(Intent(this, MainActivity::class.java))
            }
        }
    }
}