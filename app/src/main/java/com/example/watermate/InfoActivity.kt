package com.example.watermate

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.os.Bundle
import android.widget.Button

@Suppress("DEPRECATION")
class InfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overridePendingTransition(0, 0)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        setContentView(R.layout.activity_info)
        supportActionBar?.hide()

        val pop = MediaPlayer.create(this, R.raw.pop)

        val button = findViewById<Button>(R.id.back)
        button.setOnClickListener {
            pop.start()
            val intent = Intent(this, FunctionalActivity::class.java)
            startActivity(intent)
        }
    }
}
