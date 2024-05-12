package com.example.meta.Session_3

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.meta.R
import com.example.meta.Session_2.Choose_Platform

class lenta_home_page_image_only : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lenta_home_page_image_only)

        val card_to_all : ImageButton = findViewById(R.id.imageButton_Card_Switch_image_only)
        val search : ImageButton = findViewById(R.id.imageButtonSearch_Inactive_image_only)
        val favor : ImageButton = findViewById(R.id.imageButtonFavorite_Inactive_image_only)
        val profile : ImageButton = findViewById(R.id.imageButtonProfile_Inactive_image_only)

        profile.setOnClickListener {
            val intent = Intent(this, Choose_Platform::class.java)
            startActivity(intent)
        }
        favor.setOnClickListener {
            val intent = Intent(this, Choose_Platform::class.java)
            startActivity(intent)
        }
        search.setOnClickListener {
            val intent = Intent(this, Choose_Platform::class.java)
            startActivity(intent)
        }

        card_to_all.setOnClickListener {
            val intent = Intent(this, lenta_home_page::class.java)
            startActivity(intent)
        }
    }
}