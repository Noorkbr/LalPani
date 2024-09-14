package com.example.lalpani.DomainLayer

import androidx.annotation.Keep

@Keep
data class Drink(
    val id :String,
    val name: String,
    val imageUrl : String

)
