package com.example.jetquestionnaire

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.jetquestionnaire.ui.theme.EnterDate
import com.example.jetquestionnaire.ui.theme.JetQuestionnaireTheme
import com.example.jetquestionnaire.ui.theme.RadioButtonTest

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetQuestionnaireTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //add scaffold
                    Scaffold() {innerpadding ->
                        Column(
                            modifier = Modifier
                                .fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Top
                        ) {
                            LazyColumnDemo()
                        }
                    }
                    
                }
            }
        }
    }
}



//lazy column testing
@Composable
fun LazyColumnDemo() {
    //question_list entar ambil dari api
    val question_list = listOf(
        "1", "2", "3", "4","5","6","7","8","9","10","11","12","13","14","15","16")
    LazyColumn(modifier = Modifier.fillMaxHeight()) {
        items(question_list) {item ->
            RadioButtonTest()
        }

    }
}





