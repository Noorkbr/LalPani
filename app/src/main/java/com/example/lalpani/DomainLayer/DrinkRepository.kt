package com.example.lalpani.DomainLayer


import com.example.lalpani.DataLayer.ResponseDrinkDto
import retrofit2.Response

interface DrinkRepository {
    suspend fun getDrinkList(drinkName: String): Response<ResponseDrinkDto>
}