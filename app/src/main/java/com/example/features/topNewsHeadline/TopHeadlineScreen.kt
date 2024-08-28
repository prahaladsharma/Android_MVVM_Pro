package com.example.features.topNewsHeadline

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.features.base.intent.NewsIntent

@Composable
fun TopHeadlineScreen(
    viewModel: TopHeadlineViewModel = hiltViewModel(),
    navigateToDetail: (id: String) -> Unit
){
    val state = viewModel.uiState.collectAsState().value

    LaunchedEffect(Unit) {
        viewModel.handleIntent(NewsIntent.LoadTopNews)
    }

    NewsScreenRendering(

    )

}

@Composable
private fun NewsScreenRendering(){
}