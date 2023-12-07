package com.example.formsexercise.screens

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.formsexercise.data.FormUiState

@Composable
fun SummaryScreen(
    formUiState: FormUiState,
    startOver: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Name: ${formUiState.name}",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Text(
            text = "Regular Customer: ${formUiState.customer}",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Text(
            text = "Normal Feedback: ${formUiState.normalFeedBack} out of 5 Stars",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Text(
            text = "Pizza Feedback: ${formUiState.pizzaFeedBack} out of 5 Stars",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Text(
            text = "Form Feedback: ${formUiState.formFeedback}",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Divider()
        Button(onClick = {
            startOver()
        }) {
            Text(text = "Start Over")
            Icon(imageVector = Icons.Default.Refresh,
                contentDescription = "Start Over")
        }

    }
}