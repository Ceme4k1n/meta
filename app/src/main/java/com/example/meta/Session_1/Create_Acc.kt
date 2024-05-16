package com.example.meta.Session_1

import android.content.Intent
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.meta.MainActivity
import com.example.meta.R
import com.example.meta.Session_2.SetupProfile
import com.google.firebase.Firebase
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.database

class Create_Acc : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_acc)

        val mail : EditText = findViewById(R.id.email)
        val pass1 : EditText = findViewById(R.id.Password)
        val pass2 : EditText = findViewById(R.id.repeatPassword)
        val register : Button = findViewById(R.id.enterButton)
        val fckGoBack : Button = findViewById(R.id.createButton)
        val vis1 : ImageButton = findViewById(R.id.visionButton)
        val vis2 : ImageButton = findViewById(R.id.visionButtonRepeat)




        vis1.setOnClickListener{
            if(pass1.transformationMethod != null){
                pass1.transformationMethod = null
            }
            else{
                pass1.transformationMethod = PasswordTransformationMethod()
            }
        }
        vis2.setOnClickListener{
            if(pass2.transformationMethod != null){
                pass2.transformationMethod = null
            }
            else{
                pass2.transformationMethod = PasswordTransformationMethod()
            }
        }

        register.setOnClickListener{        //ЗАНОС ДАННЫХ ПОЛЬЗОВАТЕЛЯ В БАЗУ ДАННЫХ (EMAIL+PASS)
            if(mail.text.isNotEmpty()&&pass1.text.isNotEmpty()&&pass2.text.toString()==pass1.text.toString()){
                enterSandman()
            }
            val database = Firebase.database
            val ref = database.getReference("users")
            data class User(val email: String?, val password: String?)

            val user = User(mail.text.toString(), pass1.text.toString())
            ref.push().setValue(user)
        }

        fckGoBack.setOnClickListener{
            goBack()
        }

    }
    fun goBack(){
        val intent = Intent(this, Registry::class.java)
        startActivity(intent)
    }
    fun enterSandman(){
        val intent = Intent(this, SetupProfile::class.java)
        startActivity(intent)
    }

}