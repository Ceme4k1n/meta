package com.example.meta.Session_1

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.ContentValues.TAG
import android.content.Intent
import android.graphics.Color
import android.nfc.Tag
import android.os.Bundle
import android.os.Debug
import android.text.Editable
import android.text.TextWatcher
import android.text.method.PasswordTransformationMethod
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.meta.MainActivity
import com.example.meta.R
import com.example.meta.Session_2.Choose_Platform
import com.example.meta.Session_2.Chose_Ptatform_Three
import com.example.meta.Session_2.SetupProfile
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.database

class Registry : AppCompatActivity() {

    val database: DatabaseReference = Firebase.database.reference
    @SuppressLint("CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registry)

        val sharedPreferences = getSharedPreferences("prefs", MODE_PRIVATE)


        val toPassword : Button = findViewById(R.id.forgotPassword)
        val toCreation : Button = findViewById(R.id.createButton)
        val enterButton : Button = findViewById(R.id.enterButton)
        val email : TextView = findViewById(R.id.email)
        val password : TextView = findViewById(R.id.Password)
        val remember : CheckBox = findViewById(R.id.rememberCheck)
        val vision : ImageButton = findViewById(R.id.visionButton)
        val boolean1 =false
//Доделать

//
//        val watcher = object : TextWatcher {
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//            }
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//                try {
//                    if (email.text.isNotEmpty() && password.text.isNotEmpty()) {
//                        enterButton.setBackgroundColor(Color.parseColor("#7576D6"))
//                        enterSandman()
//                    } else {
//                        enterButton.setBackgroundColor(Color.GRAY)
//                    }
//                }catch (e:Exception){
//                    e.printStackTrace()
//                }
//            }
//
//
//            override fun afterTextChanged(s: Editable?) {
//                TODO("Not yet implemented")
//            }
//        }
//        email.addTextChangedListener(watcher)
//        password.addTextChangedListener(watcher)
        //---------------------------------------------------------------------------
//        РАБОТАЕТ НА ПОЛОВИНУ! ПРЕДЪЯВИТЬ МОРОЗОВУ!

        toPassword.setOnClickListener{
        goToPassword()
        }

        toCreation.setOnClickListener{
            goToCreate()
        }


        enterButton.setOnClickListener{
            if(email.text.isNotEmpty()&& password.text.isNotEmpty()) {
                print(email)
                print(password)
                loginViaEmail(email.text.toString(), password.text.toString())
                enterButton.setBackgroundColor(Color.parseColor("#7576D6"))
            }else{
                enterButton.setBackgroundColor(Color.GRAY)
            }
        }
    }

    fun loginViaEmail(
        email: String,
        password: String
    ){
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                Log.d(ContentValues.TAG,"Succecfully singed in")
                enterSandman()
            }
            .addOnFailureListener { exception ->
                if (exception is FirebaseAuthInvalidUserException) {
                    // Обработка несуществующего пользователя
                    println("Пользователь с таким email не существует")
                    println(email)
                    println(password)
                } else if (exception is FirebaseAuthInvalidCredentialsException) {

                    // Обработка неверного пароля
                    println(email)
                    println(password)
                    println("Неверный пароль")
                } else {
                    // Обработка других ошибок
                    println(email)
                    println(password)
                    println("Произошла ошибка: ${exception.message}")
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
        val intent = Intent(this, Choose_Platform::class.java)
        startActivity(intent)
    }




}