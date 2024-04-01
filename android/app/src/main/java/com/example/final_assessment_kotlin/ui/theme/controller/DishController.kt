package com.example.final_assessment_kotlin.ui.theme.controller

import com.example.final_assessment_kotlin.ui.theme.model.DishResponse
import com.example.final_assessment_kotlin.ui.theme.model.SingleDishResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface DishController {
    @GET("dishes/")
    suspend fun getDishes(): Response<DishResponse>

    @GET("dishes/fetch/{id}")
    suspend fun getSingleProduct(@Path("id") id: Int) : Response<SingleDishResponse>
}