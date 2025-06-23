package com.tksohlt.instadev.view.auth.login

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.tksohlt.instadev.R
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import com.tksohlt.instadev.view.core.components.InstaButton
import com.tksohlt.instadev.view.core.components.InstaText

//Padre de login
@Composable
fun LoginScreen(loginViewModel: LoginViewModel = viewModel(), navigateToRegister: () -> Unit) {
    //collectAsStateWithLifecycle se engancha al stateFlow pero con el ciclo de vida, si la vista se termina esto se muere
    val uiState = loginViewModel.uiState.collectAsStateWithLifecycle() // esto es solo de lectura

    Scaffold { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .background(MaterialTheme.colorScheme.background)
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            //Text con wrapper
//            Text(modifier = Modifier.padding(24.dp), text = "Español (MX)", color = MaterialTheme.colorScheme.onBackground)
            InstaText(modifier = Modifier.padding(24.dp), text = stringResource(R.string.login_screen_header_text_mx))
            Spacer(Modifier.weight(1f))
            Image(
                modifier = Modifier.size(56.dp),
                painter = painterResource(R.drawable.instadev_logo),
                contentDescription = "InstaDev logo header"
            )
            Spacer(Modifier.weight(1f))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(30),
                value = uiState.value.email,
                label = {InstaText(text = stringResource(R.string.login_screen_textfield_email))},
                onValueChange = { loginViewModel.onEmailChange(it) })
            Spacer(Modifier.height(12.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(30),
                value = uiState.value.password,
                label = {InstaText(text = stringResource(R.string.login_screen_textfield_password))},
                onValueChange = { loginViewModel.onPasswordChange(it) })
            Spacer(Modifier.height(10.dp))
            InstaButton(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(R.string.login_screen_button_login),
                onClick = {  },
                enabled = uiState.value.isLoginEnabled,
            )

            TextButton(onClick = {}) { Text(stringResource(R.string.login_screen_textfield_forgot_password)) }
            Spacer(Modifier.weight(1.3f))
            OutlinedButton(
                modifier = Modifier.fillMaxWidth(),
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
                onClick = { navigateToRegister() }) { Text(stringResource(R.string.login_screen_button_register), color = MaterialTheme.colorScheme.primary)
            }
            Icon(
                modifier = Modifier
                    .width(60.dp)
                    .padding(vertical = 24.dp),
                painter = painterResource(R.drawable.ic_meta),
                contentDescription = "Meta logo",
                tint = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}