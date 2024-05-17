package com.example.meta.Session_2

import android.app.DatePickerDialog
import android.content.Intent
import android.content.res.Configuration
import android.icu.util.Calendar
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.meta.R
import com.google.firebase.Firebase
import com.google.firebase.database.database


class SetupProfile : AppCompatActivity(), DatePickerDialog.OnDateSetListener {
    var day = 0
    var month = 0
    var year = 0
    var sMonth = 0
    var sYear = 0
    var sDay = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setup_profile)
        val plus : ImageButton = findViewById(R.id.plus_button)
        val Fio : EditText = findViewById(R.id.editTextFIO)
        val phone : EditText = findViewById(R.id.editTextPhone)
        val date : TextView = findViewById(R.id.editTextDate)
        val addImage : ImageButton = findViewById(R.id.adding_avatar_button)
        val chngStyle : ImageButton = findViewById(R.id.white_theme_button)
        val next : Button = findViewById(R.id.button)
        val avatar : ImageView = findViewById(R.id.imageAvatar)

        fun changeTheme() {
            val currentTheme = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
            if (currentTheme == Configuration.UI_MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }

            }
        chngStyle.setOnClickListener{
            changeTheme()
            recreate()
        }

        val selectImageIntent = registerForActivityResult(ActivityResultContracts.GetContent())
        { uri ->
            avatar.setImageURI(uri)
        }
        plus.setOnClickListener{
            goToPlatforms()
        }

        addImage.setOnClickListener{
            selectImageIntent.launch("image/*")
        }

        next.setOnClickListener{
            if(Fio.text.isNotEmpty()&&phone.text.isNotEmpty()&&date.text.isNotEmpty()){
                goIn()
            }
        }
        date.setOnClickListener{
            DatePickerDialog(this,this,year,month,day).show()

            date.text = "${sDay}.${sMonth+1}.${sYear}"
        }

        val database = Firebase.database
        val ref = database.getReference("users")
        data class User(val Fio: String?, val phone: String?, val date: String?)

        val user = User(Fio.text.toString(), phone.text.toString(), date.text.toString())
        ref.push().setValue(user)


    }

    fun goToPlatforms(){
        val intent = Intent(this, Chose_Ptatform_Three::class.java)
        startActivity(intent)
    }
    fun goIn(){
        val intent = Intent(this, Choose_Platform::class.java)
        startActivity(intent)
    }

    private fun getDateCalendar(){
        val cal : Calendar = Calendar.getInstance()
        day = cal.get(Calendar.DAY_OF_MONTH)
        month = cal.get(Calendar.MONTH)
        year = cal.get((Calendar.YEAR))
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        sDay = dayOfMonth
        sMonth = month
        sYear = year

        getDateCalendar()
    }

}