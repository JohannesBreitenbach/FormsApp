package com.example.formsexercise.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
/*
import androidx.compose.material3.icons.Icons
import androidx.compose.material3.icons.filled.ArrowBack
import androidx.compose.material3.icons.filled.Star
import androidx.compose.material3.icons.filled.StarBorder
import androidx.compose.material3.icons.filled.StarHalf*/
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.formsexercise.screens.components.FormTitle
import com.example.formsexercise.R
@Composable
fun StarRatingScreen(
    isPizza: Boolean,
    navigateBack: () -> Unit,
    navigateToNextScreen: () -> Unit,
    onValueChange: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    var selectedRating by remember { mutableStateOf(0) }
    val context = LocalContext.current

    Column(
        modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if(isPizza){
            FormTitle(text = "How would you rate the Pizza at the mensa?")
            Spacer(modifier = Modifier.height(16.dp))
            Image(painter = painterResource(id = R.drawable.pizza), contentDescription = "Pizza")
        }else{
            FormTitle(text = "How would you rate the regular mensa food?")
            Spacer(modifier = Modifier.height(16.dp))
            Image(painter = painterResource(id = R.drawable.normal_food), contentDescription =null )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            (1..5).forEach { rating ->
                StarRatingItem(
                    rating = rating,
                    isSelected = rating <= selectedRating,
                    onRatingSelected = {
                        selectedRating = rating
                        onValueChange(it)
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {
                // Handle button click (submit rating or navigate to the next screen)
                // For now, just display a toast with the selected rating
                Toast.makeText(context, "You rated the food: $selectedRating stars", Toast.LENGTH_SHORT).show()
                navigateToNextScreen()
            }
        ) {
            Text("Continue Form")
        }
    }
}

@Composable
fun StarRatingItem(
    rating: Int,
    isSelected: Boolean,
    onRatingSelected: (Int) -> Unit
) {
    val icon = when {
        isSelected -> Icons.Default.Star
        else -> {Icons.Default.Star}
    }

    Icon(
        imageVector = icon,
        contentDescription = null,
        tint = if (isSelected) Color(0xFFFFC107) else MaterialTheme.colorScheme.onBackground,
        modifier = Modifier
            .size(48.dp)
            .clickable { onRatingSelected(rating) }
    )
}
