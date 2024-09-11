package com.example.data.repository

import com.example.data.api.NetworkApiService
import com.example.data.apiKey
import com.example.data.model.ArticleDTO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NewsDetailRepository @Inject constructor(
    private val networkApiService: NetworkApiService
) {
    fun getNewsDetail(id: String): Flow<List<ArticleDTO>> {
        return flow {
            emit(networkApiService.getNesFromSources(id, apiKey))
        }.map {
            it.articles
        }
    }
}