package com.example.formsexercise.screens

import androidx.lifecycle.ViewModel
import com.example.formsexercise.data.FormUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class FormViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(FormUiState())
    val uiState: StateFlow<FormUiState> = _uiState.asStateFlow()

    fun setName(name: String){
        _uiState.update { currentState ->
            currentState.copy(
                name = name
            )
        }
    }

    fun setCustomer(isCustomer: Boolean){
        _uiState.update { currentState ->
            currentState.copy(
                customer = isCustomer
            )
        }
    }

    fun setNormalFoodRating(feedback: Int){
        _uiState.update { currentState ->
            currentState.copy(
                normalFeedBack = feedback
            )
        }
    }

    fun setPizzaRating(feedback: Int){
        _uiState.update { currentState ->
            currentState.copy(
                pizzaFeedBack = feedback
            )
        }
    }

    fun setFormFeedback(feedback: String){
        _uiState.update { currentState ->
            currentState.copy(
                formFeedback = feedback
            )
        }
    }

}