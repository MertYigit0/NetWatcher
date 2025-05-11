package com.mertyigit0.netwatcher.presentation.connection

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mertyigit0.netwatcher.domain.model.ConnectionEvent
import com.mertyigit0.netwatcher.ui.theme.NetWatcherTheme
import dagger.hilt.android.AndroidEntryPoint
import java.time.LocalDateTime

@AndroidEntryPoint
class ConnectionActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NetWatcherTheme {
                ConnectionScreen()  // ConnectionScreen'i burada gösteriyoruz
            }
        }
    }
}

@Composable
fun ConnectionScreen(viewModel: ConnectionViewModel = hiltViewModel()) {
    val connectionState by viewModel.connectionState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        when (connectionState) {
            is ConnectionState.Loading -> {
                BasicText("Loading...")
            }
            is ConnectionState.Success -> {
                val events = (connectionState as ConnectionState.Success).events
                events.forEach { event ->
                    BasicText(
                        text = "Connection: ${if (event.isConnected) "Connected" else "Disconnected"}, Time: ${event.timestamp}"
                    )
                }
            }
            is ConnectionState.Error -> {
                BasicText((connectionState as ConnectionState.Error).message)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Simulate adding a new connection event
        Button(onClick = {
            val newEvent = ConnectionEvent(isConnected = true, timestamp = LocalDateTime.now())
            viewModel.addConnectionEvent(newEvent)
        }) {
            BasicText("Add Connection Event")
        }
    }
}
