package com.plcoding.jetpackcomposemasterclass

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.safeGestures
import androidx.compose.foundation.layout.safeGesturesPadding
import androidx.compose.foundation.layout.statusBarsIgnoringVisibility
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.widget.ConstraintLayout
import com.plcoding.jetpackcomposemasterclass.basic_layout.HotelBookingScreen
import com.plcoding.jetpackcomposemasterclass.basic_modifiers.FocusManagementModifiers
import com.plcoding.jetpackcomposemasterclass.basic_modifiers.SpacingModifierDemo
import com.plcoding.jetpackcomposemasterclass.basic_modifiers.TriangleShape
import com.plcoding.jetpackcomposemasterclass.composition_locals.LocalShape
import com.plcoding.jetpackcomposemasterclass.composition_locals.MyShapedButton
import com.plcoding.jetpackcomposemasterclass.measurements.LazyMindMap
import com.plcoding.jetpackcomposemasterclass.measurements.LazyScrolling
import com.plcoding.jetpackcomposemasterclass.measurements.MindMapItem
import com.plcoding.jetpackcomposemasterclass.measurements.SizeModifiersDemo
import com.plcoding.jetpackcomposemasterclass.measurements.SizePositionModifiersDemo
import com.plcoding.jetpackcomposemasterclass.measurements.SubcomposePagedRow
import com.plcoding.jetpackcomposemasterclass.side_effects.DisposableEffectDemo
import com.plcoding.jetpackcomposemasterclass.side_effects.LaunchedEffectDemo
import com.plcoding.jetpackcomposemasterclass.side_effects.RememberUpdatedStateDemo
import com.plcoding.jetpackcomposemasterclass.state_management.number_guess.NumberGuessScreenRoot
import com.plcoding.jetpackcomposemasterclass.ui.theme.JetpackComposeMasterclassTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeMasterclassTheme {
                CompositionLocalProvider(LocalShape provides TriangleShape) {
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                    ) { innerPadding ->
                        MyShapedButton()
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeMasterclassTheme {
        Greeting("Android")
    }
}