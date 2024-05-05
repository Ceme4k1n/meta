package com.example.meta.Session_1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.meta.R

class Forgot_Pass : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_pass)

        val email : EditText = findViewById(R.id.email)
        val ent : Button = findViewById(R.id.enterButton)
        val fckGoBack : Button = findViewById(R.id.createButton)

        ent.setOnClickListener{
            if(email.text.isNotEmpty()){
                goshaDaun()
            }
        }

        fckGoBack.setOnClickListener{
            fuckGoBack()
        }

    }
    fun fuckGoBack(){
        val intent = Intent(this, Registry::class.java)
        startActivity(intent)
    }
    fun goshaDaun(){
        val intent = Intent(this, OTP_Verrif::class.java)
        startActivity(intent)
    }
}