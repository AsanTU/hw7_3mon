package com.example.hw7_3mon.Activityes

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.hw7_3mon.Fragments.FirstFragment
import com.example.hw7_3mon.Fragments.SecondFragment
import com.example.hw7_3mon.R
import com.example.hw7_3mon.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().add(R.id.container_first, FirstFragment()).commit()
        supportFragmentManager.beginTransaction().add(R.id.container_second, SecondFragment()).commit()

        stutusBar()
    }

    private fun stutusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window: Window = window
            window.setFlags(
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
            )
            window.getDecorView()
                .setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
            window.setStatusBarColor(Color.TRANSPARENT)
        }
    }
}