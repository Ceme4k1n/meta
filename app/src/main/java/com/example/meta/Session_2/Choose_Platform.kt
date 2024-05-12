package com.example.meta.Session_2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.meta.R
import com.example.meta.Session_3.lenta_home_page

class Choose_Platform : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_platform)

        val home_button: ImageButton = findViewById(R.id.imageButtonHome1)


        home_button.setOnClickListener {
            val intent = Intent(this, lenta_home_page::class.java)
            startActivity(intent)
        }
    }
}