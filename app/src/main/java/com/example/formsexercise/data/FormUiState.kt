package com.example.formsexercise.data

data class FormUiState(
    //Results:
    val name: String = "",
    val customer: Boolean = false,
    val normalFeedBack: Int = 0,
    val pizzaFeedBack: Int = 0,
    val formFeedback: String = "",
)

/** THE PLAN:
 * Whats your name? (Text Input)
 * Do you eat at the mensa? (2 Options)
 * How would you rate the normal food? (5 Star)
 * How would you rate the pizza? (5 Star)
 * How would you rate this questionnaire? (5 Options)
 */
