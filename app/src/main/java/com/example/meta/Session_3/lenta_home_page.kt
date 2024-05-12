package com.example.meta.Session_3

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.meta.R
import com.example.meta.Session_2.SetupProfile

class lenta_home_page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lenta_home_page)

        val card_to_text_only : ImageButton = findViewById(R.id.imageButton_Card_Switch)





        card_to_text_only.setOnClickListener {
            val intent = Intent(this, lenta_home_page_text_only::class.java)
            startActivity(intent)
        }
    }
}