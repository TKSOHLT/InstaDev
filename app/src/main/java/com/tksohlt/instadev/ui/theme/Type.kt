package com.tksohlt.instadev.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.tksohlt.instadev.R

// Set of Material typography styles to start with
//NADA DEBERIA SER MAS PEQUEÑO QUE 11.sp
//display no se tocan a menos del inicio de la palicacion
//head al inicio de una pantalla grande coo por ejemplo "favoritos"
//title son los que más se usan para los titulos
//labels para las chips, compoentes y demás junto con el body

//Nota, no se ponen los colores del texto aquí
val hind = FontFamily(
    Font(R.font.hind, FontWeight.Bold),
)

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 25.sp,
        fontWeight = FontWeight.SemiBold,
        letterSpacing = 0.4.sp
    ),
)