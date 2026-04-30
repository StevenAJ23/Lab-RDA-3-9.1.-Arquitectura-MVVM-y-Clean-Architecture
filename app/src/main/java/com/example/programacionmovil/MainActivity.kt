package com.example.programacionmovil

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    SmartHome()
                }
            }
        }
    }
}

@Composable
fun SmartHome() {
    Log.d("RECOMPOSE", "DIBUJANDO PADRE (SmartHome)")

    var isLightOn by remember { mutableStateOf(false) }
    var refreshCount by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Centro de Control Domótico",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(32.dp))

        LightBulb(isOn = isLightOn)

        Spacer(modifier = Modifier.height(32.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Interruptor Principal")

            Spacer(modifier = Modifier.width(12.dp))

            Switch(
                checked = isLightOn,
                onCheckedChange = { isLightOn = it }
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { refreshCount++ }
        ) {
            Text("Refrescar UI")
        }

        Spacer(modifier = Modifier.height(12.dp))

        Text("Refrescos realizados: $refreshCount")
    }
}

@Composable
fun LightBulb(isOn: Boolean) {
    Log.d("RECOMPOSE", "DIBUJANDO HIJO (LightBulb)")

    Icon(
        imageVector = Icons.Default.Lightbulb,
        contentDescription = "Bombilla",
        modifier = Modifier.size(120.dp),
        tint = if (isOn) Color.Yellow else Color.Gray
    )
}