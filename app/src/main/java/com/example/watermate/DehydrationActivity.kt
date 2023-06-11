package com.example.watermate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

@Suppress("DEPRECATION")
class DehydrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dehydration)

        supportActionBar?.setDisplayShowTitleEnabled(false)

        window.decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_FULLSCREEN or
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
    }
}