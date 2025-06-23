package com.tksohlt.instadev.view.auth.login

import android.util.Patterns
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import org.intellij.lang.annotations.Pattern

//La forma perfecta de gestionar la vista es a traves del estado del UI (UI State)
class LoginViewModel: ViewModel() {
    //Mis composables no van a poder modificar este estado
    private val _uiState = MutableStateFlow(LoginUIState())
    //Nuestas vistas se suscriben a este flow a esta variable y por el StateFlow no pueden modificarlo
    //Esto depende de _uiState, por lo que se actualiza cada vez que se modifica
    val uiState: MutableStateFlow<LoginUIState> = _uiState //MutableStateFlow si se puede modificar (mutable) y se declaran con val

    fun onEmailChange(email: String){
        //.update es la forma recomendada para modificar el estado inmutable de manera funcional
        _uiState.update { state ->
            _uiState.value.copy(email = email)
        }
        verifyLogin()
        //Esto es lo mismo que lo de arriba
//        _uiState.update { state ->
//            state.copy(email = email)
//        }
    }

    fun onPasswordChange(password: String){
        //Igual esto es lo mismo
        _uiState.update {
            it.copy(password = password)
        }
        verifyLogin()
    }

    fun verifyLogin(){
        val enabledLogin = isEmailValid(_uiState.value.email) && isPasswordValid(_uiState.value.password)
        _uiState.update {
            it.copy(isLoginEnabled = enabledLogin)
        }

    }

    //Función del sistema (matcher) y dice si es una dirección de correo válida, pero
    //TODO: esto es android, y el viewmodel no debe saber nada de android
    fun isEmailValid(email: String): Boolean = Patterns.EMAIL_ADDRESS.matcher(email).matches()
    fun isPasswordValid(password: String): Boolean = password.length >= 6
}

data class LoginUIState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val isLoginEnabled: Boolean = false
)

//Esto se puede usar en listas que tienen listado, detalles, demàs
//sealed class MyUIState{
//    object Error
//    data class Success(val test:String)
//}