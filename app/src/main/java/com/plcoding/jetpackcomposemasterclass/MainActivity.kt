package com.plcoding.jetpackcomposemasterclass

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.safeGestures
import androidx.compose.foundation.layout.safeGesturesPadding
import androidx.compose.foundation.layout.statusBarsIgnoringVisibility
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.widget.ConstraintLayout
import com.plcoding.jetpackcomposemasterclass.basic_layout.HotelBookingScreen
import com.plcoding.jetpackcomposemasterclass.basic_modifiers.FocusManagementModifiers
import com.plcoding.jetpackcomposemasterclass.basic_modifiers.SpacingModifierDemo
import com.plcoding.jetpackcomposemasterclass.measurements.SizeModifiersDemo
import com.plcoding.jetpackcomposemasterclass.measurements.SizePositionModifiersDemo
import com.plcoding.jetpackcomposemasterclass.state_management.number_guess.NumberGuessScreenRoot
import com.plcoding.jetpackcomposemasterclass.ui.theme.JetpackComposeMasterclassTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeMasterclassTheme {
                SizePositionModifiersDemo()
//                Scaffold(
//                    modifier = Modifier.fillMaxSize(),
//                ) { innerPadding ->
//                    FocusManagementModifiers(
//                        modifier = Modifier
//                            .padding(innerPadding)
//                    )
//                }
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