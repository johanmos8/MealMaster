package com.mirkwood.data.networking

import com.mirkwood.data.networking.model.CategoryResponse
import com.mirkwood.data.networking.model.MealResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {

    @GET
    suspend fun getMeals(): Response<MealResponse>

    @GET
    suspend fun getCategories(
        @Url url: String
    ): Response<CategoryResponse>
}