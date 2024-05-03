package com.example.jetquestionnaire

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetquestionnaire.ui.theme.JetQuestionnaireTheme

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
                    Frame98Preview()
                    Frame211Preview()
                }
            }
        }
    }
}

//apa itu diabetes self management questionnaire
@Composable
fun Frame98(modifier: Modifier = Modifier){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .requiredWidth(width = 360.dp)
            .requiredHeight(height = 52.dp)
            .background(color = Color(0xff5799fc))
            .padding(
                start = 16.dp,
                end = 62.dp,
                top = 16.dp,
                bottom = 16.dp
            )
    ) {
Icon(imageVector = Icons.Default.ArrowBack,
     contentDescription = "back arrow",
     modifier = Modifier.requiredSize(size = 20.dp))
Text(text = "Diabetes Self-Management Questionnaire",
     color = Color.White,
    style = TextStyle(
        fontSize = 15.sp,
        fontWeight = FontWeight.Bold))
    }
}

//preview
@Preview(widthDp = 360, heightDp = 52)
@Composable
private fun Frame98Preview(){
    Frame98(Modifier)

}

@Composable
fun Frame211(modifier: Modifier = Modifier){
    Column( verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .requiredWidth(width = 360.dp)
            .padding(all = 8.dp)
    ) {
        Property1Primary()
    }
}

@Composable
fun Property1Primary(modifier: Modifier = Modifier) {
    Row(horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .requiredHeight(height = 44.dp)
            .clip(shape = RoundedCornerShape(32.dp))
            .background(color = Color(0xff5799fc))
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        Text(text = buildAnnotatedString {
            withStyle(style = SpanStyle(
                color = Color.White,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold)) {append("Apa itu Diabetes Self Management Questionnaire?")}
        })
    }
}

@Preview(widthDp = 360, heightDp = 60)
@Composable
private fun Frame211Preview(){
    Frame211(Modifier)
}


