package com.example.data.api

import com.example.data.model.TopHeadlinesResponseDTO
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface NetworkApiService {
    @Headers("X-Api-Key: API_KEY")
    @GET("top-headlines")
    suspend fun getTopHeadlines(@Query("country") country: String): TopHeadlinesResponseDTO
}