package com.example.meta.Session_1

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.meta.MainActivity
import com.example.meta.R
import com.example.meta.Session_2.Choose_Platform
import com.example.meta.Session_2.Chose_Ptatform_Three

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
    }


    fun goToPassword(){
        val intent = Intent(this, Forgot_Pass::class.java)
        startActivity(intent)
    }
    fun  goToCreate(){
        val intent = Intent(this, Create_Acc::class.java)
        startActivity(intent)
    }
    fun enterSandman(){
        val intent = Intent(this, Chose_Ptatform_Three::class.java)
        startActivity(intent)
    }



}