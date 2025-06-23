package com.tksohlt.instadev.view.auth.login

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
import com.tksohlt.instadev.R

//Padre de login
@Preview
@Composable
fun LoginScreen() {
    var email = remember { mutableStateOf("") }
    var password = remember { mutableStateOf("") }

    Scaffold { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .background(Color.White)
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Español (España)", color = Color.Gray, modifier = Modifier.padding(24.dp))
            Spacer(Modifier.weight(1f))
            Image(
                modifier = Modifier.size(72.dp),
                painter = painterResource(R.drawable.instadev_logo),
                contentDescription = "InstaDev logo header"
            )
            Spacer(Modifier.weight(1f))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(30),
                value = email.value,
                onValueChange = { email.value = it })
            Spacer(Modifier.height(12.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(30),
                value = password.value,
                onValueChange = { password.value = it })
            Spacer(Modifier.height(10.dp))
            Button(
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
                onClick = {}) {
                Text(
                    modifier = Modifier.padding(vertical = 4.dp),
                    text = "Iniciar sesión"
                )
            }
            TextButton(onClick = {}) { Text("Has olvidado la contraseña?") }
            Spacer(Modifier.weight(1f))
            OutlinedButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = {}) { Text("Crear una cuenta nueva") }
            Icon(
                modifier = Modifier
                    .width(60.dp)
                    .padding(vertical = 24.dp),
                painter = painterResource(R.drawable.ic_meta),
                contentDescription = "Meta logo",
                tint = Color.Gray
            )
        }
    }
}