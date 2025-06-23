package com.tksohlt.instadev.view.auth.register

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.tksohlt.instadev.R

@Composable
fun RegisterScreen(registerViewModel: RegisterViewModel = RegisterViewModel(), navigateBack: ()-> Unit) {

    val uiState = registerViewModel.uiState.collectAsStateWithLifecycle()

    Scaffold { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .background(MaterialTheme.colorScheme.background)
                .padding(horizontal = 20.dp)
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Back",
                modifier = Modifier
                    .padding(vertical = 10.dp)
                    .size(24.dp)
                    .clickable { navigateBack() }
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(if (uiState.value.isRegisterWithPhone) R.string.register_screen_phone_header_text else R.string.register_screen_email_header_text),
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                modifier = Modifier.padding(bottom = 15.dp, top = 10.dp),
                text = stringResource(if (uiState.value.isRegisterWithPhone) R.string.register_screen_instructions_phone_text else R.string.register_screen_instructions_email_text),
            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(30),
                value = uiState.value.phone,
                onValueChange = {
                    if (uiState.value.isRegisterWithPhone) registerViewModel.onChangePhone(
                        it
                    ) else registerViewModel.onChangeEmail(it)
                },
                label = { Text(text = stringResource(if (uiState.value.isRegisterWithPhone) R.string.register_screen_textfield_phone else R.string.register_screen_textfield_email)) })

            Text(
                modifier = Modifier.padding(bottom = 15.dp, top = 10.dp),
                text = stringResource(if (uiState.value.isRegisterWithPhone) R.string.register_screen_instructions_remember_phone_text else R.string.register_screen_instructions_remember_email_text)
            )

            Button(
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                enabled = uiState.value.isRegisterEnabled,
                onClick = {}) {
                Text(text = stringResource(R.string.register_screen_button_continue))
            }

            OutlinedButton(
                modifier = Modifier.fillMaxWidth(),
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
                onClick = { registerViewModel.onChangeRegisterPhone(!uiState.value.isRegisterWithPhone) }) {
                Text(text = stringResource(if (uiState.value.isRegisterWithPhone) R.string.register_screen_button_register_email else R.string.register_screen_button_register_phone))
            }
            Spacer(modifier = Modifier.weight(1f))
        }
    }

}