package com.example.a19012021065_assignment2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView


class DASHBOARD_MAIN : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard_main)

        var bottomnavview = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        //bottomnavview.selectedItemId = R.id.bottomNavigationView
        bottomnavview.selectedItemId=R.id.bottomNavigationView

        bottomnavview.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.hotel1 -> {
                    Intent(this, HOTEL_MAIN::class.java).apply {
                        startActivity(this)
                    }
                    return@setOnItemSelectedListener true
                }
                else -> {
                    Intent(this, DASHBOARD_MAIN::class.java).apply {
                        startActivity(this)
                    }
                    return@setOnItemSelectedListener true

                }
            }
        }






        val images = listOf<Image>(
            Image("Images 1", R.drawable.image1),
            Image("Images 2", R.drawable.image2),
            Image("Images 3", R.drawable.image3),
            Image("Images 4", R.drawable.image4),
            Image("Images 5", R.drawable.image5)
        )

        val recyclerView = findViewById<RecyclerView>(R.id.ImageRecyclerview1)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = ImageAdapter(this, images)
    }


}