package com.example.u2y3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
// import androidx.activity.enableEdgeToEdge // Descoméntalo si quieres diseño de borde a borde
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
// import androidx.compose.material3.Scaffold // Descomenta si vas a usar Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.u2y3.ui.theme.U2Y3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // enableEdgeToEdge() // Activa si necesitas diseño sin márgenes
        setContent {
            U2Y3Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NotificationScreen()
                }
            }
        }
    }
}

/**
 * Devuelve el mensaje de notificación según la cantidad.
 */
fun getNotificationMessage(numberOfMessages: Int): String {
    return if (numberOfMessages < 100) {
        "You have $numberOfMessages notifications."
    } else {
        "Your phone is blowing up! You have 99+ notifications."
    }
}

/**
 * Pantalla que muestra dos mensajes de notificaciones.
 */
@Composable
fun NotificationScreen(modifier: Modifier = Modifier) {
    val morningNotification = 51
    val eveningNotification = 135

    val morningMessage = getNotificationMessage(morningNotification)
    val eveningMessage = getNotificationMessage(eveningNotification)

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = morningMessage,
            fontSize = 18.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = eveningMessage,
            fontSize = 18.sp
        )
    }
}

/**
 * Vista previa para el editor.
 */
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun NotificationScreenPreview() {
    U2Y3Theme {
        NotificationScreen()
    }
}
