package com.example.meta.Session_2

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.meta.R
import com.example.meta.Session_3.lenta_home_page
import com.example.meta.Session_4.favorite_page
import com.example.meta.Session_5.map_page

class Choose_Platform : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_platform)

        val home_button: ImageButton = findViewById(R.id.imageButtonHome1)
        val search : ImageButton = findViewById(R.id.imageButtonSearch)
        val favor : ImageButton = findViewById(R.id.imageButtonFavorite_chose_platform)
        val profile : ImageButton = findViewById(R.id.imageButtonProfile)

        profile.setOnClickListener {
            val intent = Intent(this, Choose_Platform::class.java)
            startActivity(intent)
        }
        favor.setOnClickListener {
            val intent = Intent(this, favorite_page::class.java)
            startActivity(intent)
        }
        home_button.setOnClickListener {
            val intent = Intent(this, lenta_home_page::class.java)
            startActivity(intent)
        }

        search.setOnClickListener {
            val intent = Intent(this, map_page::class.java)
            startActivity(intent)
        }
    }
}