package com.example.meta.Session_5

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.meta.R
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
        mapview.map.move(CameraPosition(Point(55.922419, 37.814935), 20.0f, 0.0f, 0.0f),
        Animation(Animation.Type.SMOOTH, 1f), null)
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