package com.example.lalpani.DataLayer

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface DrinkApiService {
    @GET("json/v1/1/filter.php")
    suspend fun getRandomDrink(@Query("c") DrinksCategoryName:String): Response<ResponseDrinkDto>
}


