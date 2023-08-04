package com.example.introduceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random

class IntroducePage : AppCompatActivity() {

    // 랜덤으로 가져올 이미지 배열
    private val imageArray = arrayOf(
        R.drawable.ehu,
        R.drawable.black,
        R.drawable.home,
        R.drawable.vivaldi,
        R.drawable.suitmask
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_introduce_page)


        val strData = intent.getStringExtra("dataFromMainActivity")
        val editText = findViewById<TextView>(R.id.IdView)
        editText.text = strData


        // 로그인 페이지로 돌아가기
        val close = findViewById<Button>(R.id.close)
        close.setOnClickListener {
            finish()
        }

        // 랜덤 이미지
        val randomMyPhoto :ImageView = findViewById(R.id.MyPhoto) // 랜덤 이미지 보여주기 위한 변수
        val randomPhotoResouce =imageArray[Random.nextInt(imageArray.size)] // 이미지 배열에서 랜덤으로 이미지 선택

        randomMyPhoto.setImageResource(randomPhotoResouce)// 랜덤으로 가져온 이미지를 Image view에 설정해서 보여준다.
    }
}