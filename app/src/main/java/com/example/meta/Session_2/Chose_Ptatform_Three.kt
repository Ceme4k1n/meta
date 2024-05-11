package com.example.meta.Session_2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.meta.R
import com.example.meta.Session_1.Registry

class Chose_Ptatform_Three : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chose_ptatform_three)

        val Exit_Krest: ImageButton = findViewById(R.id.imageButton2)
        val plus_button1: ImageButton = findViewById(R.id.plus_button1)
        val plus_button2: ImageButton = findViewById(R.id.plus_button2)
        val plus_button3: ImageButton = findViewById(R.id.plus_button3)
        val Galochka1: ImageButton = findViewById(R.id.imageButtonGalochka1)
        val Galochka2: ImageButton = findViewById(R.id.imageButtonGalochka2)
        val Galochka3: ImageButton = findViewById(R.id.imageButtonGalochka3)
        var Bubbles_Bool: Boolean = false
        var VK_Bool: Boolean = false
        var LOC_Bool: Boolean = false

        plus_button1.setOnClickListener{
            plus_button1.visibility = View.INVISIBLE
            Bubbles_Bool = true
            Galochka1.visibility = View.VISIBLE
        }

        plus_button2.setOnClickListener {
            plus_button2.visibility = View.INVISIBLE
            VK_Bool = true
            Galochka2.visibility = View.VISIBLE
        }

        plus_button3.setOnClickListener {
            plus_button3.visibility = View.INVISIBLE
            LOC_Bool = true
            Galochka3.visibility = View.VISIBLE
        }

        Galochka1.setOnClickListener {
            Galochka1.visibility = View.INVISIBLE
            Bubbles_Bool = false
            plus_button1.visibility = View.VISIBLE
        }

        Galochka2.setOnClickListener {
            Galochka2.visibility = View.INVISIBLE
            VK_Bool = false
            plus_button2.visibility = View.VISIBLE
        }

        Galochka3.setOnClickListener {
            Galochka3.visibility = View.INVISIBLE
            LOC_Bool = false
            plus_button3.visibility = View.VISIBLE
        }

        Exit_Krest.setOnClickListener {
            val intent = Intent(this, Choose_Platform::class.java)
            startActivity(intent)
        }
    }
}