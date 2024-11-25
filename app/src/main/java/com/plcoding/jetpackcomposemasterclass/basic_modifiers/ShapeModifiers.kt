package com.plcoding.jetpackcomposemasterclass.basic_modifiers

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.plcoding.jetpackcomposemasterclass.R
import com.plcoding.jetpackcomposemasterclass.ui.theme.JetpackComposeMasterclassTheme

@Composable
fun ShapeModifiersDemo(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(R.drawable.kermit),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .clip(TriangleShape)
    )
}

data object TriangleShape: Shape {

    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        return Outline.Generic(
            path = Path().apply {
                moveTo(
                    x = size.width / 2f,
                    y = 0f
                )
                lineTo(
                    x = 0f,
                    y = size.height
                )
                lineTo(
                    x = size.width,
                    y = size.height
                )
                close()
            }
        )
    }
}

@Preview(
    showBackground = true
)
@Composable
private fun ShapeModifiersDemoPreview() {
    JetpackComposeMasterclassTheme {
        ShapeModifiersDemo()
    }
}