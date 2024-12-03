package com.plcoding.jetpackcomposemasterclass.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import com.plcoding.jetpackcomposemasterclass.R

val Jaro = FontFamily(
    Font(
        resId = R.font.jaro_regular,
        weight = FontWeight.Normal,
    ),
    Font(
        resId = R.font.jaro_60pt_regular,
        weight = FontWeight.Bold,
    ),
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp,
    ),
    displayLarge = TextStyle(
        fontSize = 26.sp,
        fontWeight = FontWeight.Black,
        fontStyle = FontStyle.Italic,
        textDecoration = TextDecoration.Underline,
        fontFamily = FontFamily.Default
    )
)