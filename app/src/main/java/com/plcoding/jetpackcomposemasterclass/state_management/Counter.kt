package com.plcoding.jetpackcomposemasterclass.state_management

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.plcoding.jetpackcomposemasterclass.ui.theme.JetpackComposeMasterclassTheme

private const val BASE_URL = "https://..."
private var counter by mutableIntStateOf(0)

@Composable
fun Counter(modifier: Modifier = Modifier) {
    var items by rememberSaveable {
        mutableStateOf(
            listOf<String>(
            "Item"
        ))
    }
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = {
                items += "Item"
            }
        ) {
            Text("Add item")
        }
        Text(
            text = items.toString(),
            modifier = Modifier
                .align(Alignment.TopCenter)
        )
    }
}

@Preview(
    showBackground = true
)
@Composable
private fun CounterPreview() {
    JetpackComposeMasterclassTheme {
        Counter()
    }
}