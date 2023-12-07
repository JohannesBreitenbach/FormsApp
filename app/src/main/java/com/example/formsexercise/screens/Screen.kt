package com.example.formsexercise.screens

sealed class Screen(val route: String) {
    object WelcomeScreen: Screen("welcome_screen")
    object CustomerScreen: Screen("customer_screen")
    object NormalFoodScreen: Screen("normal_food_screen")
    object PizzaScreen: Screen("pizza_screen")
    object FormFeedbackScreen: Screen("form_feedback_screen")
    object SummaryScreen: Screen("summary_screen")
}