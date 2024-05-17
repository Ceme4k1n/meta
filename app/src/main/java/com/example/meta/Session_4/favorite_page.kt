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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite_page)

        val home_button: ImageButton = findViewById(R.id.imageButtonHome_Active_text_only1)
        val search : ImageButton = findViewById(R.id.imageButtonSearch_Inactive_text_only1)
        val profile : ImageButton = findViewById(R.id.imageButtonProfile_Inactive_text_only1)

        profile.setOnClickListener {
            val intent = Intent(this, Choose_Platform::class.java)
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