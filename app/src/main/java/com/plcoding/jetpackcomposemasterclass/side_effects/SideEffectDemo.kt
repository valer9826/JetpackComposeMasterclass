package com.plcoding.jetpackcomposemasterclass.side_effects

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.plcoding.jetpackcomposemasterclass.ui.theme.JetpackComposeMasterclassTheme

@Composable
fun SideEffectDemo(modifier: Modifier = Modifier) {
    var counter by remember {
        mutableIntStateOf(0)
    }
    Button(
        onClick = {
            counter++
        }
    ) {
        counter++
        Text("Counter: $counter")
    }
}

@Preview
@Composable
private fun SideEffectDemoPreview() {
    JetpackComposeMasterclassTheme {
        SideEffectDemo()
    }
}