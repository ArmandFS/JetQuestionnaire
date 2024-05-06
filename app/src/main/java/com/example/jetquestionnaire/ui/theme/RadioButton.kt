package com.example.jetquestionnaire.ui.theme

import android.widget.RadioButton
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier

@Composable
fun RadioButtonTest(){
    val options = listOf("0", "1", "2", "3")
    var selectedOption by remember { mutableStateOf(options[0]) }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        options.forEach { option ->
            Row {
               androidx.compose.material3.RadioButton(
                   selected = selectedOption == option,
                   onClick = { selectedOption = option })
                Text(text = option)
            }
        }
    }

}