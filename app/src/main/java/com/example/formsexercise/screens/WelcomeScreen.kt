package com.example.formsexercise.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.formsexercise.R
import com.example.formsexercise.screens.components.FormTitle
import com.example.formsexercise.screens.components.FormsTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WelcomeScreen(
    navigateToCustomerScreen: () -> Unit,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var name by remember { mutableStateOf("") }
    var isButtonEnabled by remember { mutableStateOf(false) }
    val context = LocalContext.current

    Column(
        modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        FormTitle(text = "Welcome to this years mensa feedback!")
        Spacer(modifier = Modifier.height(32.dp))
        Image(
            painter = painterResource(id = R.drawable.chef), // Replace with your image resource
            contentDescription = null,
            modifier = Modifier
                .clip(RoundedCornerShape(50.dp))
                .padding(16.dp)
        )
        Spacer(modifier = Modifier.height(64.dp))

        OutlinedTextField(
            value = name,
            onValueChange = {
                name = it
                isButtonEnabled = it.isNotBlank()
                onValueChange(it)
            },
            label = { Text("Enter your name") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Text
            ),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary
                )
            },
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))


        Button(
            onClick = {
                navigateToCustomerScreen()
            },
            //Toast.makeText(context, "Welcome, $name!", Toast.LENGTH_SHORT).show() ,
            enabled = isButtonEnabled
        ) {
            Text("Continue")
        }
    }
}
