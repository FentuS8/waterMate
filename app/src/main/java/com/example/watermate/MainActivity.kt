package com.example.watermate

import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.os.Bundle
import android.content.res.Resources
import android.widget.ListView
import android.widget.ArrayAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val abilitiesArray = resources.getStringArray(R.array.possibilities_list)

        val listView = findViewById<ListView>(R.id.possibilities)

        val adapter = CustomArrayAdapter(this, android.R.layout.simple_list_item_1, abilitiesArray)
        listView.adapter = adapter

        supportActionBar?.setDisplayShowTitleEnabled(false)

        // Удаление полосы сверху экрана
        window.decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_FULLSCREEN or
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
    }
}
