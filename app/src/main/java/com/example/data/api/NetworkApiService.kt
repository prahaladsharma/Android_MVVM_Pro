package com.example.data.api

import com.example.BuildConfig
import com.example.data.COUNTRY
import com.example.data.SOURCES
import com.example.data.TOP_HEADLINES
import com.example.data.TOP_HEADLINES_SOURCES
import com.example.data.model.TopHeadlinesResponseDTO
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface NetworkApiService {
    @GET(TOP_HEADLINES)
    suspend fun getTopHeadlines(
        @Query(COUNTRY) country: String,
        @Header("X-Api-Key") apiKey: String = BuildConfig.API_KEY,
        ): TopHeadlinesResponseDTO

    @GET(TOP_HEADLINES_SOURCES)
    suspend fun getNewsFromSources(
        @Query(SOURCES) sources: String,
        @Header("X-Api-Key") apiKey: String = BuildConfig.API_KEY,
    ): TopHeadlinesResponseDTO

}
