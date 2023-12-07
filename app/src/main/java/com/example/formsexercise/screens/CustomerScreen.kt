package com.example.formsexercise.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.formsexercise.screens.components.FormTitle
import com.example.formsexercise.R

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun CustomerScreen(
    navigateBack: () -> Unit,
    onValueChange: (Boolean) -> Unit,
    navigateToNormalFoodScreen: () -> Unit,
    modifier: Modifier = Modifier
) {
    var answer by remember { mutableStateOf("") }
    val context = LocalContext.current
    val keyboardController = LocalSoftwareKeyboardController.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        FormTitle(text = "Do you regularly eat at the mensa?")

        Spacer(modifier = Modifier.height(8.dp))

        Image(
            painter = painterResource(id = R.drawable.thinking_cook),
            contentDescription = "Thinking Cook")

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            //No
            Button(onClick = {
                onValueChange(false)
                answer = "No"
                Toast.makeText(context, "Selected Answer: $answer", Toast.LENGTH_SHORT).show()
                navigateToNormalFoodScreen()
            }
            ) {
                Text(text = "Continue with No")
            }
            //Yes
            Button(
                onClick = {
                    onValueChange(true)
                    answer = "Yes"
                    Toast.makeText(context, "Selected Answer: $answer", Toast.LENGTH_SHORT).show()
                    navigateToNormalFoodScreen()
                },
            ) {
                Text(text = "Continue with Yes")
            }
        }
    }
}

@Preview
@Composable
fun CusPreview() {
    CustomerScreen(
        navigateBack = { /*TODO*/ },
        onValueChange = {},
        navigateToNormalFoodScreen = { /*TODO*/ })
}