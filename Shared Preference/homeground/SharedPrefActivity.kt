package com.kalpicapp.homeground

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.shared_layout.*

class SharedPrefActivity :AppCompatActivity() {


    var Score = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.shared_layout)


        val mypreference = MyPreference(this)
        val HighScore = mypreference.getHighScore()
        textView2.text = HighScore.toString()


        addonebtn.setOnClickListener {
            Score++
            scoretextview.text = Score.toString()
            if (Score>HighScore){
                mypreference.setHighScore(Score)
                textView2.text = Score.toString()

            }

        }





    }

}
