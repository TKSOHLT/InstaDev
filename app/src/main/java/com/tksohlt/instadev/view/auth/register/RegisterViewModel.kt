package com.tksohlt.instadev.view.auth.register

import android.util.Patterns
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class RegisterViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(RegisterUiState())
    val uiState: MutableStateFlow<RegisterUiState> = _uiState

    fun onChangePhone(phone: String){
        _uiState.update {
            it.copy(phone = phone)
        }
        verifyPhone()
    }

    fun onChangeEmail(email: String){
        _uiState.update {
            it.copy(email = email)
        }
    }

    fun onChangeRegisterPhone(isRegisterWithPhone: Boolean){
        _uiState.update {
            it.copy(isRegisterWithPhone = isRegisterWithPhone)
        }
    }

    fun verifyPhone(){
        if(_uiState.value.isRegisterWithPhone){
            _uiState.update {
                it.copy(isRegisterEnabled = isPhoneValid(_uiState.value.phone))
            }
        }else{
            _uiState.update {
                it.copy(isRegisterEnabled = isEmailValid(it.email))
            }
        }
    }

    fun isPhoneValid(phone: String): Boolean = phone.length == 10
    fun isEmailValid(email: String): Boolean = Patterns.EMAIL_ADDRESS.matcher(email).matches()
}

data class RegisterUiState(
    val phone: String = "",
    val email: String = "",
    val isLoading: Boolean = false,
    val isRegisterEnabled: Boolean = false,
    val isRegisterWithPhone: Boolean = false
)