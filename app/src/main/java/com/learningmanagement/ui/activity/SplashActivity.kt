package com.learningmanagement.ui.activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import com.learningmanagement.R
import com.learningmanagement.databinding.ActivitySplashBinding
import com.learningmanagement.constants.Utils

class SplashActivity : AppCompatActivity() {
    private val SPLASH_TIME_OUT: Long = 3000
    lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getInitUI()
    }
    private fun getInitUI(): Unit {
        if (Utils.isInternetConnected(applicationContext)) {
            Handler().postDelayed({
                startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
                overridePendingTransition(R.anim.enter, R.anim.exit)
                finish()
            }, SPLASH_TIME_OUT)
        }else{
            Toast.makeText(applicationContext,resources.getString(R.string.oops_connect_your_internet),Toast.LENGTH_LONG).show()
        }
    }
}
