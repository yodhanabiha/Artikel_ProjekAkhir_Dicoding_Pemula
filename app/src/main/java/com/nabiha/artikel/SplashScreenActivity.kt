package com.nabiha.artikel

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.nabiha.artikel.databinding.ActivityHomeBinding
import com.nabiha.artikel.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : AppCompatActivity() {

    private val TIME_DELAY: Long = 2000
    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = resources.getColor(R.color.background)
        }

        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val icon = binding.splashIcon
        val rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate_animation)
        icon.startAnimation(rotateAnimation)

        Handler().postDelayed({
            // Intent untuk berpindah ke aktivitas berikutnya (misalnya, MainActivity)
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish() // Tutup aktivitas splash screen
        }, TIME_DELAY)
    }
}