package com.example.lalpani.di


import com.example.lalpani.DataLayer.DrinkApiService
import com.example.lalpani.DataLayer.DrinkRepositoryImpl
import com.example.lalpani.DomainLayer.DrinkRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DrinkAppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://www.thecocktaildb.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideMealApiService(
        retrofit: Retrofit
    ): DrinkApiService {
        return retrofit.create(DrinkApiService::class.java)

    }

    @Provides
    @Singleton
    fun provideRepo(
        apiService: DrinkApiService
    ): DrinkRepository {
        return DrinkRepositoryImpl(apiService)

    }


}