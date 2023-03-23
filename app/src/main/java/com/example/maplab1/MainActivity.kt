package com.example.maplab1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.maplab1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    lateinit var adapter: AnimalAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val rv = binding.rv

        adapter = AnimalAdapter { animal, position ->
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra(MY_ANIMAL_KEY, animal)
            startActivity(intent)
        }
        adapter.setNewData(createAnimals())

        rv.adapter = adapter
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//
//    }

    companion object {
        val MY_ANIMAL_KEY = "animal"
    }
}