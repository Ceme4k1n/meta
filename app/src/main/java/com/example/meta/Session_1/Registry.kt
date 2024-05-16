package com.example.meta.Session_1

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Debug
import android.text.Editable
import android.text.TextWatcher
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
import com.example.meta.Session_2.SetupProfile
import com.google.firebase.Firebase
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
        val password : TextView = findViewById(R.id.password)
        val remember : CheckBox = findViewById(R.id.rememberCheck)
        val vision : ImageButton = findViewById(R.id.visionButton)
        val passwordField : TextView = findViewById(R.id.Password)

        val mail = sharedPreferences.getString("mail",null)
        val pass = sharedPreferences.getString("pass",null)
//Доделать
        if(email.text.isNotEmpty() && password.text.isNotEmpty()) {
            enterButton.setBackgroundResource(R.color.purple)
            password.text = pass
            email.text = mail
        }
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
                //СЮДА БД
                sharedPreferences.edit().putString("mail",email.text.toString()).apply()
                sharedPreferences.edit().putString("pass",password.text.toString()).apply()
                    //НИЖЕ ПОПЫТКА СДЕЛАТЬ АВТОРИЗАЦИЮ. ДЛЯ ПОДРОБНОСТЕЙ ОПУСТИТЕСЬ НИЖЕ!
//                val database = Firebase.database
//                val ref = database.getReference("users")
//
//                authenticateUser() { isAuthenticated ->
//                    if (isAuthenticated) {
//                        // Пользователь успешно аутентифицирован
//                        // Можно предоставить доступ к защищенным данным
//                    } else {
//                        // Не удалось аутентифицировать пользователя
//                        // Можно обработать это соответствующим образом
//                    }
//                }
                    //СЮДА БД
            }
            if(email.text.isNotEmpty()&& password.text.isNotEmpty()) {
                enterButton.setBackgroundColor(Color.parseColor("#7576D6"))
                enterSandman()
            }else{
                enterButton.setBackgroundColor(Color.GRAY)
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
        val intent = Intent(this, SetupProfile::class.java)
        startActivity(intent)
    }
//                   Я ХЗ. МБ Я ПОЛНЫЙ ДАУН, НО ВОТ ФУНКЦИЯ КОТОРУЮ МНЕ ГПТ ПРЕДЛОЖИЛ. Я ПОПЫТАЛСЯ ЕЁ ВЫШЕ ВЫЗВАТЬ - НЕ ПОЛУЧИЛОСЬ. 99 Процентов что просто я еблан полный
//    fun authenticateUser(email: String, password: String, callback: (Boolean) -> Unit) {
//        // Получаем ссылку на узел с пользователями в базе данных
//        val usersRef = database.child("users")
//
//        // Проверяем, существует ли пользователь с таким email
//        usersRef.orderByChild("email").equalTo(email).get().addOnSuccessListener { snapshot ->
//            if (snapshot.exists()) {
//                // Получаем данные пользователя из снимка
//                val user = snapshot.children.first().getValue(User::class.java)
//
//                // Проверяем соответствие пароля
//                if (user?.password == password) {
//                    // Пользователь аутентифицирован успешно
//                    callback(true)
//                } else {
//                    // Неправильный пароль
//                    callback(false)
//                }
//            } else {
//                // Пользователь с таким email не найден
//                callback(false)
//            }
//        }.addOnFailureListener {
//            // Обработка ошибок
//            callback(false)
//        }
//    }
//
//    // Класс для представления пользователя
//    data class User(val email: String, val password: String)

}