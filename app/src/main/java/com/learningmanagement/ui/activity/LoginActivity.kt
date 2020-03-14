package com.learningmanagement.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.learningmanagement.R
import com.learningmanagement.databinding.ActivityLoginBinding
import com.learningmanagement.parent_account.activity.LoginParentActivity
import com.learningmanagement.ui.constant.Utils

class LoginActivity : AppCompatActivity() {
    val TAG = "LoginActivity"
    lateinit var loginBinding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(loginBinding.root)
        initUI()
    }

    fun initUI(): Unit {
        if (Utils.isInternetConnected(applicationContext)) {
            loginBinding.circleImgTeacher.setOnClickListener(View.OnClickListener { v ->
                if (Utils.isInternetConnected(applicationContext)) {
                    startActivity(Intent(this@LoginActivity, TeacherLoginActivity::class.java))
                    overridePendingTransition(R.anim.enter, R.anim.exit)
                } else {
                    Toast.makeText(
                        this@LoginActivity,
                        resources.getString(R.string.oops_connect_your_internet),
                        Toast.LENGTH_LONG
                    ).show()
                }
            })
            loginBinding.circleImgParent.setOnClickListener(View.OnClickListener { v ->
                if (Utils.isInternetConnected(applicationContext)) {
                    startActivity(Intent(this@LoginActivity, LoginParentActivity::class.java))
                    overridePendingTransition(R.anim.enter, R.anim.exit)
                } else {
                    Toast.makeText(
                        this@LoginActivity,
                        resources.getString(R.string.oops_connect_your_internet),
                        Toast.LENGTH_LONG
                    ).show()
                }
            })
        } else {
            Toast.makeText(
                this@LoginActivity,
                resources.getString(R.string.oops_connect_your_internet),
                Toast.LENGTH_LONG
            ).show()
        }
    }
}
