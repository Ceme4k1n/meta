package com.example.meta.Session_3

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.meta.R

class lenta_home_page_image_only : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lenta_home_page_image_only)

        val card_to_all : ImageButton = findViewById(R.id.imageButton_Card_Switch_image_only)

        card_to_all.setOnClickListener {
            val intent = Intent(this, lenta_home_page::class.java)
            startActivity(intent)
        }
    }
}