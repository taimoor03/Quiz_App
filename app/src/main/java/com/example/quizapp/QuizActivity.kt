package com.example.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class QuizActivity : AppCompatActivity() , View.OnClickListener{

        private var progressBar:ProgressBar?=null
        private var questionss:TextView?=null
        private var images:ImageView?=null
        private var tvProgressbar:TextView?=null
        private var optionone:TextView?=null
        private var optiontwo:TextView?=null
        private var optionthree:TextView?=null
        private var optionfour:TextView?=null
        private var mUserName:String?=null
        private var mCurrentPosition:Int=1
        private var mQuestionlist:ArrayList<Questions>?=null
        private var mSelectedOptionPosition:Int=0
        private var submitbtn:Button?=null
        private var mCorrectAnswers:Int=0

     //   @SuppressLint("SuspiciousIndentation")
        @SuppressLint("MissingInflatedId", "SuspiciousIndentation")
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        progressBar=findViewById(R.id.progressBar)
        questionss=findViewById(R.id.question_tv)
        images=findViewById(R.id.flag_image)
        tvProgressbar=findViewById(R.id.tvprogressbar)
        optionone=findViewById(R.id.option_one)
        optiontwo=findViewById(R.id.option_two)
        optionthree=findViewById(R.id.option_three)
        optionfour=findViewById(R.id.option_four)
        submitbtn=findViewById(R.id.submit_btn)

         optionone?.setOnClickListener(this)
         optiontwo?.setOnClickListener(this)
         optionthree?.setOnClickListener(this)
         optionfour?.setOnClickListener(this)
            submitbtn?.setOnClickListener(this)

         mUserName=intent.getStringExtra(Constants.USER_NAME)
        mQuestionlist=Constants.getQustions()

            setQuestion()

        }


    @SuppressLint("SetTextI18n")
    private fun setQuestion() {

        val question: Questions = mQuestionlist!![mCurrentPosition - 1]
        defaultOptionsView()
        if (mCurrentPosition== mQuestionlist!!.size){
            submitbtn?.text="FINISH"
        }
        else{
            submitbtn?.text="SUBMIT"
        }
        progressBar?.progress = mCurrentPosition
     //   tvProgressbar?.text = "$mCurrentPosition" +  "/" + "$progressBar?.max".toString()
        questionss?.text = question.question
        images?.setImageResource(question.image)
        optionone?.text = question.optionOne
        optiontwo?.text = question.optionTwo
        optionthree?.text = question.optionThree
        optionfour?.text = question.optionFour


    }
    override fun onClick(view: View?) {
        when(view?.id){
            R.id.option_one->{
                optionone?.let {
                    selectedOptionView(it,1)
                }
            }
            R.id.option_two->{
                optiontwo?.let {
                    selectedOptionView(it,2)
                }
            }
            R.id.option_three->{
                optionthree?.let {
                    selectedOptionView(it,3)
                }
            }
            R.id.option_four-> {
                optionfour?.let {
                    selectedOptionView(it,4)
                }
            }
            R.id.submit_btn->{
                if(mSelectedOptionPosition==0){
                    mCurrentPosition++
                    when{mCurrentPosition<= mQuestionlist!!.size ->{
                        setQuestion()
                    }
                        else -> {

                            val intent=Intent(this,ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME,mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS,mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS,mQuestionlist?.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                }

                else{
                    val questioon=mQuestionlist?.get(mCurrentPosition-1)
                    if(questioon!!.correctAnswer!=mSelectedOptionPosition){
                        answerview(mSelectedOptionPosition,R.drawable.wrong_option_border)
                    }
                    else{
                        mCorrectAnswers++
                    }

                    answerview(questioon.correctAnswer,R.drawable.correct_option_border)
                    if(mCurrentPosition==mQuestionlist!!.size){
                        submitbtn?.text="FINISH"
                    }
                    else {
                        submitbtn?.text="Go to next question"
                    }
                    mSelectedOptionPosition=0
                }
            }



        }

    }

     private fun defaultOptionsView(){
         val options=ArrayList<TextView>()
         optionone?.let {
             options.add(0,it)
         }
         optiontwo?.let {
             options.add(1, it)
         }
         optionthree?.let {
             options.add(2,it)
         }
         optionfour?.let {
             options.add(3,it) }

         for(option in options){
             option.setTextColor(Color.parseColor("#7A8089"))
             option.typeface= Typeface.DEFAULT
                option.background= ContextCompat.getDrawable(this,R.drawable.textview_border_shape)
         }
     }

    private fun selectedOptionView(tv:TextView,selectedOptionNum:Int){
        defaultOptionsView()
        mSelectedOptionPosition=selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background=ContextCompat.getDrawable(this,R.drawable.selected_border)
    }

        private fun answerview(answer:Int,drawableView:Int){
        when(answer){
            1->{
                optionone?.background=ContextCompat.getDrawable(this,drawableView)
            }
            2->{
                optiontwo?.background=ContextCompat.getDrawable(this,drawableView)
            }
            3->{
                optionthree?.background=ContextCompat.getDrawable(this,drawableView)
            }
            4->{
                optionfour?.background=ContextCompat.getDrawable(this,drawableView)
            }
        }
        }




}