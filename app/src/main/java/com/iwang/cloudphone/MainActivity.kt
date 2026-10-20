
package com.iwang.cloudphone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IwangApp()
        }
    }
}

@Composable
fun IwangApp() {
    val bg = Color(0xFF080D18)
    val panel = Color(0xFF151E30)
    val cyan = Color(0xFF35D9FF)
    var running by remember { mutableStateOf(false) }

    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(bg)
                .padding(22.dp),
            verticalArrangement = Arrangement.spacedBy(18.dp)
        ) {
            Text(
                "IWANG CLOUD PHONE",
                color = cyan,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                "Cloud device dashboard",
                color = Color.LightGray
            )

            Card(
                colors = CardDefaults.cardColors(
                    containerColor = panel
                ),
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    Text("ANDROID DEVICE", color = cyan)
                    Text(
                        if (running) "Device is running" else "Device is stopped",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        "Local demo · No cloud server connected",
                        color = Color.LightGray,
                        fontSize = 12.sp
                    )
                    Button(
                        onClick = { running = !running },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = cyan,
                            contentColor = Color.Black
                        )
                    ) {
                        Text(if (running) "STOP DEVICE" else "START DEVICE")
                    }
                }
            }

            Text("SERVICES", color = cyan, fontWeight = FontWeight.Bold)
            InfoCard("Cloud Android", "Not connected", panel)
            InfoCard("Remote access", "Not configured", panel)
            InfoCard("24/7 mode", "Requires a cloud server", panel)

            Spacer(modifier = Modifier.weight(1f))
            Text(
                "IWANG CLOUD PHONE · VERSION 1.0",
                color = Color.Gray,
                fontSize = 11.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}

@Composable
fun InfoCard(title: String, subtitle: String, panel: Color) {
    Card(
        colors = CardDefaults.cardColors(containerColor = panel),
        shape = RoundedCornerShape(14.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(title, color = Color.White, fontWeight = FontWeight.Bold)
                Text(subtitle, color = Color.LightGray, fontSize = 12.sp)
            }
        }
    }
}
