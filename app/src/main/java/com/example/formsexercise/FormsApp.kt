package com.example.formsexercise

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.formsexercise.data.DataSource
import com.example.formsexercise.screens.CustomerScreen
import com.example.formsexercise.screens.FormFeedbackScreen
import com.example.formsexercise.screens.FormViewModel
import com.example.formsexercise.screens.Screen
import com.example.formsexercise.screens.StarRatingScreen
import com.example.formsexercise.screens.SummaryScreen
import com.example.formsexercise.screens.WelcomeScreen
import com.example.formsexercise.screens.components.FormsTopAppBar

/**
 * Composable that displays the topBar and displays back button if back navigation is possible.
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MensaFormApp(
    viewModel: FormViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()

    Scaffold(
        topBar = {
            FormsTopAppBar(
                navigateBack = { navController.navigateUp() }
            )
        }
    ) { innerPadding ->
        val uiState by viewModel.uiState.collectAsState()

        NavHost(
            navController = navController,
            startDestination = Screen.WelcomeScreen.route,
            modifier = Modifier.padding(innerPadding)
        )
        {
            composable(route = Screen.WelcomeScreen.route) {
                WelcomeScreen(
                    navigateToCustomerScreen = {
                        navController.navigate(Screen.CustomerScreen.route)
                    },
                    onValueChange ={ viewModel.setName(it)},
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
            composable(route = Screen.CustomerScreen.route) {
                CustomerScreen(
                    navigateBack = {
                        navController.popBackStack()
                    },
                    onValueChange = {viewModel.setCustomer(it)},
                    navigateToNormalFoodScreen = {
                        navController.navigate(Screen.NormalFoodScreen.route)
                    })
            }
            composable(route = Screen.NormalFoodScreen.route) {
                StarRatingScreen(
                    isPizza = false,
                    navigateBack = { navController.popBackStack() },
                    navigateToNextScreen = {
                        navController.navigate(Screen.PizzaScreen.route)
                    },
                    onValueChange ={ viewModel.setNormalFoodRating(it)},
                    modifier = Modifier
                        .fillMaxHeight()
                )
            }
            composable(route = Screen.PizzaScreen.route) {
                StarRatingScreen(
                    isPizza = true,
                    navigateBack = { navController.popBackStack() },
                    navigateToNextScreen = {
                        navController.navigate(Screen.FormFeedbackScreen.route)
                    },
                    onValueChange ={ viewModel.setPizzaRating(it)},
                    modifier = Modifier
                        .fillMaxHeight()
                )
            }
            composable(route = Screen.FormFeedbackScreen.route) {
                FormFeedbackScreen(
                    options = DataSource.feedbackOptions,
                    onNextButtonClicked = {
                        navController.navigate(Screen.SummaryScreen.route)
                    },
                    onSelectionChanged = {
                        viewModel.setFormFeedback(it)
                    }
                )
            }
            composable(route = Screen.SummaryScreen.route) {
                SummaryScreen(
                    formUiState = uiState,
                    startOver = {
                        navController.popBackStack(
                            route = Screen.WelcomeScreen.route,
                            inclusive = false
                        )
                    }
                )
                /*For starting over
                navController.popBackStack(
                    route = Screen.WelcomeScreen.route
                    inclusive = false
                )*/
            }
        }
    }
}
