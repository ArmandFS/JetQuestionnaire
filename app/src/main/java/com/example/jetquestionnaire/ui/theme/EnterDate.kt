package com.example.jetquestionnaire.ui.theme


import android.content.Context
import android.icu.util.Calendar
import android.widget.DatePicker
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import android.app.DatePickerDialog
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.intl.Locale
import java.text.SimpleDateFormat
import java.util.*



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EnterDate (modifier: Modifier = Modifier){
    Surface(color = Color.White,
        modifier = modifier
                   .fillMaxWidth()){
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
        ) {
            Text(text = "Input Tanggal Pengisian DSMQ",
                textAlign = TextAlign.Center,
                modifier = modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            val datePickerState = rememberDatePickerState(initialDisplayMode = DisplayMode.Input)
            DatePicker(state = datePickerState)
        }
    }
}

//2nd alternative date picker
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomInputField(
    valueState: String,
    placeholder: String,
    trailingIcon: (@Composable () -> Unit)?,
    keyboardType: KeyboardType,
    imeAction: ImeAction,
    onValueChange: (String) -> Unit,
    onClick: () -> Unit
) {
    TextField(
        value = valueState,
        onValueChange = onValueChange,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() },
        placeholder = { Text(text = placeholder) },
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = keyboardType,
            imeAction = imeAction
        ),
        trailingIcon = trailingIcon,
        singleLine = true
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EnterDate2(){
    val mCalendar = Calendar.getInstance()
    mCalendar.time = Date()
    var tanggalDsmq by rememberSaveable() {mutableStateOf("")}
    val isValidInputs by remember { derivedStateOf { tanggalDsmq.isNotEmpty() }}

    //date picker dialog
    val datePickerDialog = DatePickerDialog(
        LocalContext.current,
        { _, year, month, dayOfMonth ->
            tanggalDsmq = "$dayOfMonth/${month + 1}/$year"
        }, mCalendar.get(Calendar.YEAR), mCalendar.get(Calendar.MONTH), mCalendar.get(Calendar.DAY_OF_MONTH)
    )

    //ui elements for date
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = "Isi Tanggal DSMQ",
             modifier = Modifier
                 .fillMaxWidth()
                 .padding(bottom = 4.dp, top = 16.dp),
              style = MaterialTheme.typography.caption,



            )

    }


}
