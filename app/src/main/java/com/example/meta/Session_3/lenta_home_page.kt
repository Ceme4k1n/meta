package com.example.meta.Session_3

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.meta.R
import com.example.meta.Session_2.Choose_Platform
import com.example.meta.Session_4.favorite_page
import com.example.meta.Session_5.map_page

class lenta_home_page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lenta_home_page)

        val card_to_text_only : ImageButton = findViewById(R.id.imageButton_Card_Switch)
        val search : ImageButton = findViewById(R.id.imageButtonSearch_Inactive)
        val favor : ImageButton = findViewById(R.id.imageButtonFavorite_Inactive)
        val profile : ImageButton = findViewById(R.id.imageButtonProfile_Inactive)

        profile.setOnClickListener {
            val intent = Intent(this, Choose_Platform::class.java)
            startActivity(intent)
        }
        favor.setOnClickListener {
            val intent = Intent(this, favorite_page::class.java)
            startActivity(intent)
        }
        search.setOnClickListener {
            val intent = Intent(this, map_page::class.java)
            startActivity(intent)
        }
        card_to_text_only.setOnClickListener {
            val intent = Intent(this, lenta_home_page_text_only::class.java)
            startActivity(intent)
        }
    }
}