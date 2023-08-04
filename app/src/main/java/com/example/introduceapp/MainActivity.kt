package com.example.introduceapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // 아이디와 비밀번호 둘 중에 하나라도 입력이 안되있으면 토스트 메시지 출력 하고 안 넘어가기
        val login = findViewById<Button>(R.id.login)
        login.setOnClickListener {
            var input_id = findViewById<EditText>(R.id.InputID)
            var input_pass = findViewById<EditText>(R.id.InputPassword)
            val strData = input_id.text.toString()

            when {
                input_id.text.isNotBlank() && input_pass.text.isNotBlank() -> {
                    val intent = Intent(this, IntroducePage::class.java)
                    intent.putExtra("dataFromMainActivity", strData)
                    startActivity(intent)
                }
                input_id.text.isBlank() && input_pass.text.isNotBlank() -> {
                    input_id.requestFocus()
                    Toast.makeText(this, "ID를 확인해주세요", Toast.LENGTH_SHORT).show()
                }
                input_pass.text.isBlank() && input_id.text.isNotBlank() -> {
                    input_pass.requestFocus()
                    Toast.makeText(this, "pass를 확인해주세요", Toast.LENGTH_SHORT).show()
                }
                input_pass.text.isBlank() && input_id.text.isBlank() -> {
                    Toast.makeText(this, "ID/Pass를 확인해주세요", Toast.LENGTH_SHORT).show()
                }
            }

            //  Join버튼 클릭 시 회원가입 페이지 이동
            val join = findViewById<Button>(R.id.join)
            join.setOnClickListener {
                val intent = Intent(this, JoinMembership::class.java)
                resultLauncher.launch(intent)
            }
        }
        setResultNext()
    }

    private fun setResultNext(){
        resultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) { result ->
            // JoinMembership부터 돌아올 때의 결과 값을 받아 올 수 있는 구문
            if (result.resultCode == RESULT_OK) {
                val joinId = result.data?.getStringExtra("ID") ?: ""
                val joinPass = result.data?.getStringExtra("Pass") ?: ""

                findViewById<EditText>(R.id.InputID)?.setText(joinId)
                findViewById<EditText>(R.id.InputPassword)?.setText(joinPass)


            }
        }
    }
}