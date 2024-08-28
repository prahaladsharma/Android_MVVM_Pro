package com.example.data.repository

import com.example.data.api.NetworkApiService
import com.example.data.model.ArticleDTO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TopHeadlineRepository @Inject constructor(
    private val networkApiService: NetworkApiService
) {

    fun getTopHeadlines(country: String): Flow<List<ArticleDTO>> {
        return flow {
            emit(networkApiService.getTopHeadlines(country))
        }.map {
            it.articles
        }
    }

}
