package com.example.meta.Session_4

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.meta.R
import com.example.meta.Session_2.Choose_Platform
import com.example.meta.Session_3.lenta_home_page
import com.example.meta.Session_5.govno.one_govno_page
import com.example.meta.Session_5.map_page

class favorite_page : AppCompatActivity() {

    val imageButtonHome_Active_text_only : ImageButton = findViewById(R.id.imageButtonHome_Active_text_only)
    val imageButtonSearch_Inactive : ImageButton = findViewById(R.id.imageButtonSearch_Inactive)
    val imageButtonProfile_Inactive_text_only : ImageButton = findViewById(R.id.imageButtonProfile_Inactive_text_only)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite_page)




        imageButtonHome_Active_text_only.setOnClickListener {
            val intent = Intent(this, lenta_home_page::class.java)
            startActivity(intent)
        }

        imageButtonSearch_Inactive.setOnClickListener {
            val intent = Intent(this, map_page::class.java)
            startActivity(intent)
        }

        imageButtonProfile_Inactive_text_only.setOnClickListener {
            val intent = Intent(this, Choose_Platform::class.java)
            startActivity(intent)
        }
    }
}