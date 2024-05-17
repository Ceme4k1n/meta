package com.example.meta.Session_5

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.meta.MainActivity
import com.example.meta.R
import com.example.meta.Session_2.Choose_Platform
import com.example.meta.Session_3.lenta_home_page
import com.example.meta.Session_3.lenta_home_page_text_only
import com.example.meta.Session_4.favorite_page
import com.example.meta.Session_5.govno.one_govno_page
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.mapview.MapView

class map_page : AppCompatActivity() {

    lateinit var mapview:MapView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MapKitFactory.setApiKey("36d76377-ac12-46d8-bdb5-7369b638ba87")
        MapKitFactory.initialize(this)
        setContentView(R.layout.activity_map_page)
        mapview = findViewById(R.id.map_page_test)
        val home_button: ImageButton = findViewById(R.id.imageButtonHome_map)
        val favor : ImageButton = findViewById(R.id.imageButtonFavorite_map)
        val profile : ImageButton = findViewById(R.id.imageButtonProfile_map)

        profile.setOnClickListener {
            val intent = Intent(this, Choose_Platform::class.java)
            startActivity(intent)
        }
        favor.setOnClickListener {
            val intent = Intent(this, favorite_page::class.java)
            startActivity(intent)
        }
        home_button.setOnClickListener {
            val intent = Intent(this, lenta_home_page::class.java)
            startActivity(intent)
        }





    }

    override fun onStop() {
        mapview.onStop()
        MapKitFactory.getInstance().onStop()
        super.onStop()
    }

    override fun onStart() {
        mapview.onStart()
        MapKitFactory.getInstance().onStart()
        super.onStart()
    }


}