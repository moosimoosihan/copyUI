package com.example.copyui

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import com.example.copyui.databinding.ActivityLogInBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LogInActivity : AppCompatActivity() {

    lateinit var email_edit : EditText
    lateinit var password_edit : EditText

    lateinit var binding: ActivityLogInBinding

    lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //초기화
        email_edit = findViewById(R.id.email_edit)
        password_edit = findViewById(R.id.password_edit)

        //인증 초기화
        mAuth = Firebase.auth

        //로그인 버튼 이벤트
        binding.loginBtn.setOnClickListener {

            val email = binding.emailEdit.text.toString()
            val password = binding.passwordEdit.text.toString()

            login(email, password)
        }

        //회원가입 버튼 이벤트
        binding.signUpBtn.setOnClickListener {
            val intent: Intent = Intent(this@LogInActivity, SignUpActivity::class.java)
            startActivity(intent)
        }
    }

    /**
     * 로그인
     */
    private fun login(email: String, password: String){
        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    //성공 시 실행
                    val intent: Intent = Intent(this@LogInActivity,
                        MainActivity::class.java)
                    startActivity(intent)
                    Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
                    finish()
                } else {
                    //실패 시 실행
                    Toast.makeText(this, "로그인 실패", Toast.LENGTH_SHORT).show()
                    Log.d("Login", "Error: ${task.exception}")
                }
            }
    }
    /**
     * 화면 없어지면 실행
     */
    override fun onStop() {
        super.onStop()
        //정보 저장
        saveData()
    }
    /**
     * 화면 보여지면 실행
     */
    override fun onResume() {
        super.onResume()
        //정보 불러오기
        restoreData()
    }

    /**
     * 정보 저장
     */
    private fun saveData(){

        //저장 객체
        val pref: SharedPreferences = getSharedPreferences("pref", Activity.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = pref.edit()

        //정보 변수에 담기
        val email = email_edit.text.toString()
        val pw = password_edit.text.toString()

        //저장
        editor.putString("email", email)
        editor.putString("pw", pw)
        editor.commit()
    }

    /**
     * 정보 불러오기
     */
    private fun restoreData(){
        val pref: SharedPreferences = getSharedPreferences("pref", Activity.MODE_PRIVATE)

        if(pref != null){

            //정보 변수에 담기
            val email = pref.getString("email", "")
            val pw = pref.getString("pw", "")

            //화면에 보여주기
            email_edit.setText(email)
            password_edit.setText(pw)
        }
    }
}