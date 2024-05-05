package com.example.meta.Session_1

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Im
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

class New_Pass : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_pass)

        val pass1 : EditText = findViewById(R.id.Password)
        val pass2 : EditText = findViewById(R.id.repeatPassword)
        val vis1 : ImageButton = findViewById(R.id.visionButton)
        val vis2 :ImageButton = findViewById(R.id.visionButtonRepeat)
        val fckGoBack : Button = findViewById(R.id.createButton)
        val ent : Button = findViewById(R.id.enterButton)

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

        ent.setOnClickListener{
            if(pass1.text.isNotEmpty()&&pass2.text.toString() == pass1.text.toString()){
                enterSandman()
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
    fun enterSandman(){
        val intent = Intent(this, Exit::class.java) // При наличии Сессии2 доделать ДАУНЫ!
        startActivity(intent)
    }
}