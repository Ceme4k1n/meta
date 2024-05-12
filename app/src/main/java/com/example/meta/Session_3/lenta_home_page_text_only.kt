package com.example.meta.Session_3

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.meta.R

class lenta_home_page_text_only : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lenta_home_page_text_only)

        val card_to_image_only : ImageButton = findViewById(R.id.imageButton_Card_Switch_text_only)



        card_to_image_only.setOnClickListener {
            val intent = Intent(this, lenta_home_page_image_only::class.java)
            startActivity(intent)
        }

    }
}