package com.example.introduceapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class JoinMembership : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join_membership)

        val returnSign = findViewById<Button>(R.id.Join)
        val addID = findViewById<EditText>(R.id.InputIdJoin)
        val addPass = findViewById<EditText>(R.id.InputPasswordJoin)
        val addName = findViewById<EditText>(R.id.InputNameJoin)


        returnSign.setOnClickListener {
            when {
                addID.text.isNotBlank() && addPass.text.isNotBlank() && addName.text.isNotBlank() -> {
                    val intent = Intent()
                    intent.putExtra("ID", addID.text.toString())
                    intent.putExtra("Pass", addPass.text.toString())
                    setResult(RESULT_OK, intent)
                    finish()
                }
                addID.text.isBlank() && addPass.text.isNotBlank() && addName.text.isNotBlank() -> {
                    addID.requestFocus()
                    Toast.makeText(this, "사용할 ID를 입력해주세요.", Toast.LENGTH_SHORT).show()
                }
                addID.text.isNotBlank() && addPass.text.isBlank() && addName.text.isNotBlank() -> {
                    addPass.requestFocus()
                    Toast.makeText(this, "사용할 Pass를 입력해주세요.", Toast.LENGTH_SHORT).show()
                }
                addID.text.isNotBlank() && addPass.text.isNotBlank() && addName.text.isBlank() -> {
                    addName.requestFocus()
                    Toast.makeText(this, "사용할 이름을 입력해주세요.", Toast.LENGTH_SHORT).show()
                }
                addID.text.isBlank() && addPass.text.isBlank() && addName.text.isBlank() -> {
                    Toast.makeText(this, "입력하신 정보가 없습니다.", Toast.LENGTH_SHORT).show()
                }

            }
        }
    }
}