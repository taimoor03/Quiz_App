package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        var tvname:TextView=findViewById(R.id.tv_name)
        val tvscore:TextView=findViewById(R.id.tv_score)
        val btnfinish:Button=findViewById(R.id.button_finish)

        tvname.text=intent.getStringExtra(Constants.USER_NAME)
        val correctansmwers=intent.getIntExtra(Constants.CORRECT_ANSWERS,0)
        val totalquestions=intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        tvscore.text="Your score is $correctansmwers out of $totalquestions"

        btnfinish.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }

    }
}