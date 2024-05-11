package com.example.meta.Session_2

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.meta.R


class SetupProfile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setup_profile)

        val plus : ImageButton = findViewById(R.id.plus_button)
        val Fio : EditText = findViewById(R.id.editTextFIO)
        val phone : EditText = findViewById(R.id.editTextPhone)
        val date : EditText = findViewById(R.id.editTextDate)
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

    }

    fun goToPlatforms(){
        val intent = Intent(this, Chose_Ptatform_Three::class.java)
        startActivity(intent)
    }
    fun goIn(){
        val intent = Intent(this, Choose_Platform::class.java)
        startActivity(intent)
    }
    fun selectImageInAlbum() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "image/*"
        if (intent.resolveActivity(packageManager) != null) {
            startActivityForResult(intent, REQUEST_SELECT_IMAGE_IN_ALBUM)
        }
    }
    fun takePhoto() {
        val intent1 = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (intent1.resolveActivity(packageManager) != null) {
            startActivityForResult(intent1, REQUEST_TAKE_PHOTO)
        }
    }
    companion object {
        private val REQUEST_TAKE_PHOTO = 0
        private val REQUEST_SELECT_IMAGE_IN_ALBUM = 1
    }
}