package com.learningmanagement.parent_account.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.learningmanagement.R
import com.learningmanagement.databinding.ActivityRegisterParentBinding
import com.learningmanagement.ui.constant.Utils

class RegisterParentActivity : AppCompatActivity() {
    val TAG = "RegisterParentActivity"
    lateinit var binding: ActivityRegisterParentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterParentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
    }
    fun initUI():Unit{
        binding.inHeader.tvHeaderTitle.setText(resources.getString(R.string.parent_register))
        binding.inHeader.tvBackArrow.setOnClickListener(View.OnClickListener { v ->
            onBackPressed()
        })
        binding.btnRegister.setOnClickListener(View.OnClickListener { v ->
            if (Utils.isInternetConnected(applicationContext)) {
                getRegister()
            }else{
                Toast.makeText(this@RegisterParentActivity,resources.getString(R.string.oops_connect_your_internet),Toast.LENGTH_SHORT).show()
            }
        })
    }

    fun getRegister():Unit{
        Toast.makeText(
            this@RegisterParentActivity,
            resources.getString(R.string.parent_register_succ_message),
            Toast.LENGTH_SHORT
        ).show()
        startActivity(Intent(applicationContext, LoginParentActivity::class.java))
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}
