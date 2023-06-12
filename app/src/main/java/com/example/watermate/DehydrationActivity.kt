package com.example.watermate

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.SeekBar
import com.example.watermate.custom_utils.CustomSeekbar

@Suppress("DEPRECATION")
class DehydrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dehydration)

        //seekbar
        val seekBar = findViewById<SeekBar>(R.id.seekBar)
        val customSeekbar = CustomSeekbar(this)

        val parent = seekBar.parent as ViewGroup
        val index = parent.indexOfChild(seekBar)
        parent.removeViewAt(index)
        parent.addView(customSeekbar, index, seekBar.layoutParams)


        supportActionBar?.setDisplayShowTitleEnabled(false)

        window.decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_FULLSCREEN or
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
    }
}
