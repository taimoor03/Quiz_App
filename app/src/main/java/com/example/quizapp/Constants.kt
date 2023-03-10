package com.example.quizapp

object Constants {

    const val  USER_NAME:String="user_name"
    const val TOTAL_QUESTIONS:String="total_questions"
    const val CORRECT_ANSWERS:String="correct_answers"

    fun getQustions():ArrayList<Questions>{

        val questionsList=ArrayList<Questions>()
        val que1=Questions(1,"What country this flag belong to?",
        R.drawable.pkflag,
            "Pakistan Flag",
        "Saudia Flag",
        "Turkey Flag",
        "Palestine Flag", 1
            )
        val que2=Questions(2,"What country this flag belong to?",
            R.drawable.afghn,
            "Romania Flag",
            "Afghanistan Flag",
            "Turkey Flag",
            "Angola Flag", 2
        )
        val que3=Questions(3,"What country this flag belong to?",
            R.drawable.albania,
            "Pakistan Flag",
            "Albania Flag",
            "Russia Flag",
            "Palestine Flag", 2
        )

        val que4=Questions(4,"What country this flag belong to?",
            R.drawable.algeria,
            "Algeria Flag",
            "Angola Flag",
            "Turkey Flag",
            "Bangladesh Flag", 1
        )
        val que5=Questions(5,"What country this flag belong to?",
            R.drawable.andorra,
            "UAE Flag",
            "UK Flag",
            "Afghanistan Flag",
            "Andorra Flag", 4
        )
        val que6=Questions(6,"What country this flag belong to?",
            R.drawable.angola,
            "United States Flag",
            "Saudia Flag",
            "Angola Flag",
            "Nigeria Flag", 3
        )
        val que7=Questions(7,"What country this flag belong to?",
            R.drawable.azerbhaijan,
            "Azerbaijan Flag",
            "Brazil Flag",
            "Canada Flag",
            "Indonesia Flag", 1
        )
        val que8=Questions(8,"What country this flag belong to?",
            R.drawable.bahamas,
            "Germany Flag",
            "Kuwait Flag",
            "Morocco Flag",
            "Bahamas Flag", 4
        )
        val que9=Questions(9,"What country this flag belong to?",
            R.drawable.bangladesh,
            "Nepal Flag",
            "Bangladesh Flag",
            "Bulgaria Flag",
            "Oman", 2
        )
        val que10=Questions(10,"What country this flag belong to?",
            R.drawable.chine,
            "Qatar Flag",
            "Poland Flag",
            "China Flag",
            "Romania", 3
        )
        questionsList.add(que1)
        questionsList.add(que2)
        questionsList.add(que3)
        questionsList.add(que4)
        questionsList.add(que5)
        questionsList.add(que6)
        questionsList.add(que7)
        questionsList.add(que8)
        questionsList.add(que9)
       questionsList.add(que10)

        return questionsList
    }
}