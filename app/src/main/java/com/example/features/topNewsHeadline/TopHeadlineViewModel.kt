package com.example.features.topNewsHeadline

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.model.ArticleDTO
import com.example.data.repository.TopHeadlineRepository
import com.example.features.base.intent.NewsIntent
import com.example.features.base.state.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TopHeadlineViewModel @Inject constructor(
    private val topHeadlineRepository: TopHeadlineRepository
): ViewModel() {
    private val _uiState = MutableStateFlow<UiState<List<ArticleDTO>>>(UiState.Loading)
    val uiState: StateFlow<UiState<List<ArticleDTO>>> = _uiState

    fun handleIntent(intent: NewsIntent){
        viewModelScope.launch {
            when(intent){
                is NewsIntent.LoadTopNews -> getTopNew()
                else -> {}
            }
        }
    }

    private suspend fun getTopNew() {
        topHeadlineRepository.getTopHeadlines("us")
            .catch { e ->
                _uiState.value = UiState.Error(e.toString())
            }
            .collect {
                _uiState.value = UiState.Success(it)
            }
    }
}