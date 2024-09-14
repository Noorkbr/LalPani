package com.example.lalpani.PresentationLayer

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lalpani.DomainLayer.Drink
import com.example.lalpani.DomainLayer.DrinkListUseCase
import com.example.lalpani.di.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DrinkViewModel @Inject constructor(
    private val drinkListUseCase: DrinkListUseCase
) : ViewModel() {

    private val  _drinkData = MutableLiveData<List<Drink?>>()
    val drinkData : LiveData<List<Drink?>> get() = _drinkData

    fun getDrinkData(drinkName : String){
        viewModelScope.launch{

            drinkListUseCase.invoke(drinkName).collect{ response ->
                    when(response){
                        is Resource.Error -> {}
                        is Resource.Loading -> {}
                        is Resource.Success -> {
                            response.data.let {
                                Log.d("Tage","getDrinkData: ${_drinkData.value}")
                                _drinkData.value = it
                            }
                        }

                    }                }


        }









    } }