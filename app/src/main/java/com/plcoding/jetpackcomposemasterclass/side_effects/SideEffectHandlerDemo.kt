package com.plcoding.jetpackcomposemasterclass.side_effects

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier

@Composable
fun SideEffectHandlerDemo(modifier: Modifier = Modifier) {
    SideEffect {
        println("Called after successful recomposition")
    }
}