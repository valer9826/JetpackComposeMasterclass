package com.plcoding.jetpackcomposemasterclass.side_effects

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.plcoding.jetpackcomposemasterclass.ui.theme.JetpackComposeMasterclassTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SideEffectsHomeworkViewModel : ViewModel() {

    val snackBarState = SnackbarHostState()
    val lazyColumnState = LazyListState()

    init {
        snapshotFlow {
            val layoutInfo = lazyColumnState.layoutInfo
            layoutInfo.visibleItemsInfo.lastOrNull()?.index == layoutInfo.totalItemsCount - 1
        }.onEach { isScrolledToEnd ->
            if (isScrolledToEnd) {
                snackBarState.showSnackbar("Scrolled to the bottom!")
            }
        }.launchIn(viewModelScope)
    }
}

@Composable
fun SideEffectsHomework(
    list: List<String>,
    modifier: Modifier = Modifier
) {
    val viewModel = viewModel<SideEffectsHomeworkViewModel>()

    Scaffold(
        modifier = modifier.fillMaxSize(),
        snackbarHost = {
            SnackbarHost(
                hostState = viewModel.snackBarState
            )
        }
    ) { innerPadding ->

        LazyColumn(
            state = viewModel.lazyColumnState,
            modifier = Modifier.padding(innerPadding)
        ) {
            items(list) { item ->
                Text("Item $item")
            }
        }
    }

}

@Preview(
    showBackground = true
)
@Composable
private fun SideEffectsHomeworkPreview() {
    JetpackComposeMasterclassTheme {
        SideEffectsHomework(
            list = (1..50).map {
                "$it"
            }
        )
    }
}