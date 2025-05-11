package com.mertyigit0.netwatcher.presentation

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mertyigit0.netwatcher.presentation.connection.ConnectionActivity
import com.mertyigit0.netwatcher.presentation.connection.ConnectionScreen
import com.mertyigit0.netwatcher.ui.theme.NetWatcherTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ConnectionActivity'e yönlendiriyoruz
        val intent = Intent(this, ConnectionActivity::class.java)
        startActivity(intent)

        // MainActivity'i sonlandırıyoruz, çünkü artık ConnectionActivity'e geçiyoruz
        finish()
    }
}