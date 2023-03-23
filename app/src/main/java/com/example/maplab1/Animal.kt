package com.example.maplab1

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Animal(
    val name: String,
    val description: String,
    val imageId: Int,
    val relatedColor1: String,
    val relatedColor2: String
) : Parcelable

fun createAnimals(): List<Animal> {
    return listOf(
        Animal(
            "Ben",
            "This is a Ben and he is a bat. It's his description",
            R.drawable.bat,
            "#000000",
            "#444444"
        ),
        Animal(
            "Lola",
            "This is a Lola and she is a jellyfish. It's her description",
            R.drawable.jellyfish,
            "#00FFFF",
            "#00AAAA"
        ),
        Animal(
            "Shon",
            "This is a Shon and he is a rabbit. It's his description",
            R.drawable.rabbit,
            "#d3a15f",
            "#c88937"
        )
    )
}