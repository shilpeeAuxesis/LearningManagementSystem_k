package com.learningmanagement.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.learningmanagement.R
import com.learningmanagement.databinding.ActivityTeacherLoginBinding
import com.learningmanagement.ui.constant.Utils

class TeacherLoginActivity : AppCompatActivity() {
    val TAG = "TeacherLoginAcitivity"
    lateinit var binding: ActivityTeacherLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTeacherLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        iniTUI()
    }

    fun iniTUI(): Unit {
        binding.inHeader.tvHeaderTitle.setText(resources.getString(R.string.teacher_login))
        binding.inHeader.tvBackArrow.setOnClickListener(View.OnClickListener { v ->
            onBackPressed()
        })

        if (Utils.isInternetConnected(applicationContext)) {
            binding.rLayoutRegister.setOnClickListener(View.OnClickListener { v ->
                if (Utils.isInternetConnected(applicationContext)){
                startActivity(Intent(this@TeacherLoginActivity, TeacherRegisterActivity::class.java))
                    overridePendingTransition(R.anim.enter, R.anim.exit)
                } else{
                    Toast.makeText(this@TeacherLoginActivity,resources.getString(R.string.oops_connect_your_internet),Toast.LENGTH_SHORT).show()
                }
            })
            binding.tvForgetPassword.setOnClickListener(View.OnClickListener { v ->
                if (Utils.isInternetConnected(applicationContext)){
                    startActivity(Intent(this@TeacherLoginActivity, ForgetPasswordTeacherActivity::class.java))
                    overridePendingTransition(R.anim.enter, R.anim.exit)
                } else{
                    Toast.makeText(this@TeacherLoginActivity,resources.getString(R.string.oops_connect_your_internet),Toast.LENGTH_SHORT).show()
                }
            })

            binding.btnLogin.setOnClickListener(View.OnClickListener { v ->
                if (Utils.isInternetConnected(applicationContext)){
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
                }else{
                    Toast.makeText(this@TeacherLoginActivity, resources.getString(R.string.oops_connect_your_internet), Toast.LENGTH_SHORT).show()
                }
            })
        } else {
            Toast.makeText(this@TeacherLoginActivity, resources.getString(R.string.oops_connect_your_internet), Toast.LENGTH_SHORT).show()
        }
    }

    fun getLogin():Unit{
        Toast.makeText(this@TeacherLoginActivity,resources.getString(R.string.login_succ_message),Toast.LENGTH_SHORT)
        startActivity(Intent(this@TeacherLoginActivity, TeacherDashboardActivity::class.java))
        overridePendingTransition(R.anim.enter, R.anim.exit)
    }
    override fun onBackPressed() {
        super.onBackPressed()
    }
}
