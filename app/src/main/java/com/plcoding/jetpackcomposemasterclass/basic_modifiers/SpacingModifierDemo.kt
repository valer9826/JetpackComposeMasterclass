@file:OptIn(ExperimentalLayoutApi::class, ExperimentalLayoutApi::class)

package com.plcoding.jetpackcomposemasterclass.basic_modifiers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imeNestedScroll
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.safeGesturesPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.plcoding.jetpackcomposemasterclass.ui.theme.JetpackComposeMasterclassTheme

@Composable
fun SpacingModifierDemo(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(Color.Red)
            .fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .imeNestedScroll(),
        ) {
            items(100) {
                Text(
                    text = "Item $it",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
            }
        }
        TextField(
            value = "",
            onValueChange = {},
            modifier = Modifier.imePadding()
        )
    }
}

@Preview
@Composable
private fun SpacingModifierDemoPreview() {
    JetpackComposeMasterclassTheme {
        SpacingModifierDemo()
    }
}