package com.example.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText


class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart:Button=findViewById(R.id.buttonStart)
        val username:TextInputEditText=findViewById(R.id.input)
        btnStart.setOnClickListener {
            if (username.text?.isEmpty() == true){
                Toast.makeText(this,"Name can not be empty!",Toast.LENGTH_SHORT).show()
            }
            else{
                val intent=Intent(this,QuizActivity::class.java)
                intent.putExtra(Constants.USER_NAME,username.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}