package com.plcoding.jetpackcomposemasterclass.internals

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

// Initial composition
// groups: [RestartGroup(SlotTableDemo), Group(remember), ReplaceGroup(Button), _ _ _ _ _]
// slots: [Composable(SlotTableDemo), State("Hello"), Composable(Button), _ _ _ _ _]

// After recomposition
// groups: [RestartGroup(SlotTableDemo), Group(remember), ReplaceGroup(Text) _ _ _ _]
// slots: [Composable(SlotTableDemo), State("Hello World"), Composable(Text) _ _ _ _ ]

@Composable
fun SlotTableDemo() {
    var text by remember {
        mutableStateOf("Hello")
    }
    if(text.length > 10) {
        Text(
            text = text
        )
    } else {
        Button(
            onClick = {
                text = "Hello world!"
            }
        ) {
            Text("Update")
        }
    }
}