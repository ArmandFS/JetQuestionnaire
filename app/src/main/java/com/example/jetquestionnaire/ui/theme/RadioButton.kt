package com.example.jetquestionnaire.ui.theme

import android.widget.RadioButton
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Bottom
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RadioButtonTest(){
    val options = listOf("3", "2", "1", "0")
    var selectedOption by remember { mutableStateOf(options[0]) }
    val textAboveRadioButtons = listOf(
        "Really Long Text for Testing",
        "Really Long Text for Testing",
        "Really Long Text for Testing",
        "Really Long Text for Testing")
    //custom colour
    val customSelectedColor = Color(0xFF5799FC)
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        options.zip(textAboveRadioButtons).forEach { (option, textAbove) ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .selectable(
                        selected = (selectedOption == option),
                        onClick = { selectedOption = option }
                    )
                    .padding(8.dp)
                    .weight(1f) ,
            ) {
                //above text
                Text(
                    text = textAbove,
                    modifier = Modifier
                        .padding(bottom = 5.dp)
                        .fillMaxWidth(),
                    fontSize = 13.sp,
                    textAlign = TextAlign.Center
                )
                RadioButton(
                    selected = (selectedOption == option),
                    onClick = { selectedOption = option },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = customSelectedColor,
                        unselectedColor = Color.Gray
                    )
                )
                Text(text = option,
                    modifier = Modifier.padding(top = 5.dp),
                    fontSize = 13.sp)

            }
        }
    }
}
