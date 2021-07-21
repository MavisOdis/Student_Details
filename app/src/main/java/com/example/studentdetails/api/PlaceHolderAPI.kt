package com.example.studentdetails.api

import com.example.studentdetails.models.Detail
import okhttp3.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface PlaceHolderAPI {
    @GET("items")
    suspend fun getItem(): List<Detail>

    @POST("students")
    suspend fun postDetails(
        @Body post: POST
    )
}