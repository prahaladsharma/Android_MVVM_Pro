package com.example.data.api

import com.example.data.COUNTRY
import com.example.data.SOURCES
import com.example.data.TOP_HEADLINES
import com.example.data.TOP_HEADLINES_SOURCES
import com.example.data.model.TopHeadlinesResponseDTO
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface NetworkApiService {
    @Headers("X-Api-Key: 9f6482a584804376874b848980b7a044")

    @GET(TOP_HEADLINES)
    suspend fun getTopHeadlines(@Query(COUNTRY) country: String): TopHeadlinesResponseDTO

    @GET(TOP_HEADLINES_SOURCES)
    suspend fun getNesFromSources(
        @Query(SOURCES) sources: String,
        @Query("apiKey") apiKey: String,
    ): TopHeadlinesResponseDTO

}