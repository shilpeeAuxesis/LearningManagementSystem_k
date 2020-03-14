package com.learningmanagement.ui.activity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.learningmanagement.R
import com.learningmanagement.databinding.ActivityForgetPasswordTeacherBinding
import com.learningmanagement.ui.constant.Utils

class ForgetPasswordTeacherActivity : AppCompatActivity() {
    val TAG = "ForgetPasswordTeacher"
    lateinit var binding: ActivityForgetPasswordTeacherBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgetPasswordTeacherBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
    }

    fun initUI(): Unit {
        binding.inHeader.tvHeaderTitle.setText(resources.getString(R.string.forgot_password))
        binding.inHeader.tvBackArrow.setOnClickListener(View.OnClickListener { v ->
            onBackPressed()
        })

        binding.btnForgotPassword.setOnClickListener(View.OnClickListener { v ->
            if (Utils.isInternetConnected(applicationContext)) {
                if (binding.edtEmail.text.toString().trim().isNotEmpty() && binding.edtEmail.text.toString().trim().length>0) {
                    getForget()
                } else {
                    Toast.makeText(applicationContext, resources.getString(R.string.enter_email_address_hint), Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(
                    this@ForgetPasswordTeacherActivity,
                    resources.getString(R.string.oops_connect_your_internet),
                    Toast.LENGTH_LONG
                ).show()
            }
        })
    }

    fun getForget() {
      Toast.makeText(applicationContext,"Coming soon",Toast.LENGTH_LONG).show()
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}
