package com.example.watermate

import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.watermate.databinding.ActivityFunctionalBinding

@Suppress("DEPRECATION")
class FunctionalActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFunctionalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.requestFeature(Window.FEATURE_NO_TITLE)

        window.decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_FULLSCREEN or
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE

        supportActionBar?.hide()

        binding = ActivityFunctionalBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_functional)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_dehydration, R.id.navigation_electrolites,
                R.id.navigation_water, R.id.navigation_dehydration_treatment
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
}