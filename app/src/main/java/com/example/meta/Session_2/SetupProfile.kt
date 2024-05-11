package com.example.meta.Session_2

import android.app.DatePickerDialog
import android.content.Intent
import android.icu.util.Calendar
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.meta.R



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