package com.example.meta

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Registry : AppCompatActivity() {
    @SuppressLint("CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registry)

        val sharedPreferences = getSharedPreferences("prefs", MODE_PRIVATE)


        val toPassword : Button = findViewById(R.id.forgotPassword)
        val toCreation : Button = findViewById(R.id.createButton)
        val enterButton : Button = findViewById(R.id.enterButton)
        val email : TextView = findViewById(R.id.email)
        val password : TextView = findViewById(R.id.password)
        val remember : CheckBox = findViewById(R.id.rememberCheck)
        val vision : ImageButton = findViewById(R.id.visionButton)
        val passwordField : TextView = findViewById(R.id.Password)

        val mail = sharedPreferences.getString("mail",null)
        val pass = sharedPreferences.getString("pass",null)
//Доделать
        if(mail!=null && pass!=null) {
            password.text = pass
            email.text = mail
        }

        toPassword.setOnClickListener{
        goToPassword()
        }

        toCreation.setOnClickListener{
            goToCreate()
        }

        vision.setOnClickListener{
            if(passwordField.transformationMethod != null){
            passwordField.transformationMethod = null
            }
            else{
                passwordField.transformationMethod = PasswordTransformationMethod()
            }
        }

        enterButton.setOnClickListener{
            if(remember.isChecked){
                sharedPreferences.edit().putString("mail",email.text.toString()).apply()
                sharedPreferences.edit().putString("pass",password.text.toString()).apply()
            }
            if(email.text.isNotEmpty()&& password.text.isNotEmpty()){
                //Смена цвета доделать
                enterSandman()
            }
        }

        enterButton.setOnClickListener {

            if (email.text.isNotEmpty() && password.text.isNotEmpty()) {
                enterSandman()

            }
        }




    }


    fun goToPassword(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
    fun  goToCreate(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
    fun enterSandman(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }



}