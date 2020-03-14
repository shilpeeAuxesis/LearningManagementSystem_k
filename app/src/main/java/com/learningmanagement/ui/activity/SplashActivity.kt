package com.learningmanagement.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import com.learningmanagement.R
import com.learningmanagement.databinding.ActivitySplashBinding
import com.learningmanagement.ui.constant.Utils

class SplashActivity : AppCompatActivity() {
    val TAG = "SplashActivity"
    private val SPLASH_TIME_OUT: Long = 3000
    lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
    }
    fun initUI(): Unit {
        if (Utils.isInternetConnected(applicationContext)) {
            Handler().postDelayed({
                startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
                finish()
            }, SPLASH_TIME_OUT)
        }else{
            Toast.makeText(applicationContext,resources.getString(R.string.oops_connect_your_internet),Toast.LENGTH_LONG).show()
        }
    }
}
