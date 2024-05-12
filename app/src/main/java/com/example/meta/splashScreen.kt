package com.example.meta

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.meta.Session_1.Registry
import com.example.meta.Session_5.map_page

class splashScreen : AppCompatActivity() {

    lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        handler = Handler()
        handler.postDelayed({

            var intent = Intent(this, map_page::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}