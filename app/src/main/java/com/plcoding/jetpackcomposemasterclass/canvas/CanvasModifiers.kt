package com.plcoding.jetpackcomposemasterclass.canvas

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.plcoding.jetpackcomposemasterclass.ui.theme.JetpackComposeMasterclassTheme

@Composable
fun CanvasModifiersDemo(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green)
            .drawWithCache {
                val complexLogicResult = (1..1000000).map {
                    it * it
                }
                onDrawWithContent {
                    drawCircle(Color.Red)
                    drawContent()
                    drawCircle(
                        color = Color.Yellow,
                        radius = 10.dp.toPx()
                    )
                }
            },
        contentAlignment = Alignment.Center
    ) {
        Text("Hello world")
    }
}

@Preview(
    showBackground = true
)
@Composable
private fun CanvasModifiersDemoPreview() {
    JetpackComposeMasterclassTheme {
        CanvasModifiersDemo()
    }
}