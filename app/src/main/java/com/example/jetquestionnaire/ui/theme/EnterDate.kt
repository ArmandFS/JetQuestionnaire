package com.example.jetquestionnaire.ui.theme


import android.app.DatePickerDialog
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetquestionnaire.R
import java.util.Date


//datepicker
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
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)
        .clickable { onClick() }) {
        Card(
            shape = MaterialTheme.shapes.medium,
            elevation = CardDefaults.cardElevation(2.dp),
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.background)
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
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EnterDate(){
    val mCalendar = java.util.Calendar.getInstance()
    mCalendar.time = Date()
    var tanggalDsmq by rememberSaveable() {mutableStateOf("")}
    val isValidInputs by remember { derivedStateOf { tanggalDsmq.isNotEmpty() }}

    //date picker dialog
    val datePickerDialog = DatePickerDialog(
        LocalContext.current,
        { _, year, month, dayOfMonth ->
            tanggalDsmq = "$dayOfMonth/${month + 1}/$year"
        },
        mCalendar.get(java.util.Calendar.YEAR),
        mCalendar.get(java.util.Calendar.MONTH),
        mCalendar.get(java.util.Calendar.DAY_OF_MONTH)
    )

    //ui elements for date
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Input Tanggal Pengisian DSMQ",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 2.dp, top = 16.dp),
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 17.sp,
                textAlign = TextAlign.Center,
                color = Color.Black
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        CustomInputField(
                valueState = tanggalDsmq,
                placeholder = "Isi Tanggal Pengisian",
                //calendar icon
                trailingIcon = {
                         IconButton(onClick = { datePickerDialog.show() }) {
                             Icon(contentDescription ="calendar icon", painter = painterResource(id = R.drawable.calendar) )
                         }
                },
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next,
                onValueChange = {
                    tanggalDsmq = it
                },

                onClick = {
                    datePickerDialog.show()
                }
            )
    }
}
