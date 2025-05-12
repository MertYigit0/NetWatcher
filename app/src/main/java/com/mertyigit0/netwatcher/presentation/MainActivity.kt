package com.mertyigit0.netwatcher.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mertyigit0.netwatcher.presentation.connection.ConnectionActivity
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