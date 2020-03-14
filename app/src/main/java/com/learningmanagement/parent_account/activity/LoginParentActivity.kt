package com.learningmanagement.parent_account.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.learningmanagement.R
import com.learningmanagement.databinding.ActivityLoginParentBinding
import com.learningmanagement.parent_account.MainActivity
import com.learningmanagement.ui.constant.Utils

class LoginParentActivity : AppCompatActivity() {
    val TAG = "LoginParentActivity"
    lateinit var binding: ActivityLoginParentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginParentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()
    }

    fun initUI(): Unit {
        binding.inHeader.tvHeaderTitle.setText(resources.getString(R.string.parent_login))
        binding.inHeader.tvBackArrow.setOnClickListener(View.OnClickListener { v ->
            onBackPressed()
        })

        if (Utils.isInternetConnected(applicationContext)) {
            binding.rLayoutRegister.setOnClickListener(View.OnClickListener { v ->
                if (Utils.isInternetConnected(applicationContext)) {
                    startActivity(
                        Intent(
                            this@LoginParentActivity,
                            RegisterParentActivity::class.java
                        )
                    )
                    overridePendingTransition(R.anim.enter, R.anim.exit)
                } else {
                    Toast.makeText(
                        this@LoginParentActivity,
                        resources.getString(R.string.oops_connect_your_internet),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            })
            binding.tvForgetPassword.setOnClickListener(View.OnClickListener { v ->
                if (Utils.isInternetConnected(applicationContext)) {
                    startActivity(
                        Intent(
                            this@LoginParentActivity,
                            ForgetPasswordParentActivity::class.java
                        )
                    )
                    overridePendingTransition(R.anim.enter, R.anim.exit)
                } else {
                    Toast.makeText(
                        this@LoginParentActivity,
                        resources.getString(R.string.oops_connect_your_internet),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            })

            binding.btnLogin.setOnClickListener(View.OnClickListener { v ->
                if (Utils.isInternetConnected(applicationContext)) {
                    getLogin()
                    /*if (binding.edtUsername.text.toString().trim().isNotEmpty()&& binding.edtUsername.text.toString().trim().length>0){
                        if (binding.edtPassword.text.toString().trim().isNotEmpty()&& binding.edtPassword.text.toString().trim().length>0){
                            getLogin()
                        }else{
                            Toast.makeText(this@TeacherLoginActivity,resources.getString(R.string.enter_password_hint),Toast.LENGTH_SHORT).show()
                        }
                    }else{
                        Toast.makeText(this@TeacherLoginActivity,resources.getString(R.string.enter_username_hint),Toast.LENGTH_SHORT).show()
                    }*/
                } else {
                    Toast.makeText(
                        this@LoginParentActivity,
                        resources.getString(R.string.oops_connect_your_internet),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            })
        } else {
            Toast.makeText(
                this@LoginParentActivity,
                resources.getString(R.string.oops_connect_your_internet),
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    fun getLogin(): Unit {
        Toast.makeText(this@LoginParentActivity,resources.getString(R.string.login_succ_message),Toast.LENGTH_SHORT)
        startActivity(Intent(this@LoginParentActivity, MainActivity::class.java))
        overridePendingTransition(R.anim.enter, R.anim.exit)
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}
