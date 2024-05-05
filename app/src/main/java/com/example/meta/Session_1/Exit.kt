package com.example.meta.Session_1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.meta.R

class Exit : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exit)

        val ext : Button = findViewById(R.id.enterButton)

        ext.setOnClickListener{
            exitLight()
        }
    }
    fun exitLight(){
        val intent = Intent(this, Registry::class.java)
        startActivity(intent)
    }
}