package com.tksohlt.instadev.view.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tksohlt.instadev.view.auth.login.LoginScreen
import com.tksohlt.instadev.view.auth.register.RegisterScreen

@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()
    NavHost(navController  = navController, startDestination = Login){
        composable<Login>{
            LoginScreen(navigateToRegister = {navController.navigate(Register)})
        }
        composable<Register>{
            RegisterScreen(navigateBack = {navController.navigate(Login)})
        }
    }
}