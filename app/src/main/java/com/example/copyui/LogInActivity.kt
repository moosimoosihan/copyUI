package com.example.copyui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.copyui.databinding.ActivityLogInBinding

class LogInActivity : AppCompatActivity() {

    lateinit var binding: ActivityLogInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //회원가입 버튼 이벤트
        binding.signUpBtn.setOnClickListener {
            val intent: Intent = Intent(this@LogInActivity, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}