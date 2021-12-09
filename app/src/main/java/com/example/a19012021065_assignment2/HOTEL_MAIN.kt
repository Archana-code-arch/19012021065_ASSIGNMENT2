package com.example.a19012021065_assignment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.content.Intent
import android.widget.AdapterView.OnItemClickListener
import android.widget.ListView


class HOTEL_MAIN : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotel_main)

       // val arrayAdapter: ArrayAdapter<*>
        val hotels = arrayOf("TAJ HOTEL", "OBEROI HOTEL", "5 STAR HOTEL", "NILKANTH HOTEL", "SWAMINARAYAN HOTEL")

        var mListView = findViewById<ListView>(R.id.listview)
        val arrayAdapter: ArrayAdapter<*> = ArrayAdapter<Any?>(applicationContext, android.R.layout.simple_list_item_1, hotels)
        mListView.setAdapter(arrayAdapter)

      mListView.setOnItemClickListener(OnItemClickListener
      {
              parent, view, position, id ->
            if (position == 0) {
                //clicked apple
                startActivity(Intent(this@HOTEL_MAIN, TAJ_HOTEL::class.java))
            } else if (position == 1) {
                //clicked orange
                startActivity(Intent(this@HOTEL_MAIN,OBEROI_HOTEL::class.java))
            } else if (position == 2) {
                //clicked orange
                startActivity(Intent(this@HOTEL_MAIN,FIVE_STAR_HOTEL::class.java))
            }
         else  if (position == 3) {
              //clicked orange
              startActivity(Intent(this@HOTEL_MAIN,NILKANTH_HOTEL::class.java))
          }
         else  if (position == 4) {
              //clicked orange
              startActivity(Intent(this@HOTEL_MAIN,SWAMINARAYAN_HOTEL::class.java))
          }
          else {

            }

        })
    }
}