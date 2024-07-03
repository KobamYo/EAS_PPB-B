package com.example.easppb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.easppb.ui.theme.EASPPBTheme

class IsiSaldoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EASPPBTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    IsiSaldoScreen()
                }
            }
        }
    }
}

@Composable
fun IsiSaldoScreen() {
    var balance by remember { mutableStateOf(10000) }
    var amount by remember { mutableStateOf(TextFieldValue("")) }
    var message by remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Saldo: Rp$balance", style = MaterialTheme.typography.headlineSmall)

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = amount,
            onValueChange = { newValue -> amount = newValue },
            label = { Text("Masukkan jumlah") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            val addedAmount = amount.text.toIntOrNull() ?: 0
            balance += addedAmount
            message = "Saldo berhasil diisi."
            amount = TextFieldValue("")
        }) {
            Text("Isi Saldo")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = message, style = MaterialTheme.typography.bodyLarge)
    }
}
