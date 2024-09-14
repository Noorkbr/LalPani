package com.example.lalpani.DomainLayer

import android.util.Log
import com.example.lalpani.DataLayer.toDrinkItem

import com.example.lalpani.di.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DrinkListUseCase @Inject constructor(private val repository: DrinkRepository) {

    operator fun invoke(drinkName : String) : Flow<Resource<List<Drink?>?>> = flow {

        try {
            emit(Resource.Loading())
            val data = repository.getDrinkList(drinkName)

            if (data.isSuccessful && data.body() != null) {
                val ml = data.body()!!.drinks
                val drItem = ml?.map { it?.toDrinkItem() }

                emit(Resource.Success(drItem))


            }
        }catch (e: Exception) {
            Log.d("Exception", "invoke: ${e.message}")
            emit(Resource.Error(e.message ?: "Some Error"))
        }






    }









}