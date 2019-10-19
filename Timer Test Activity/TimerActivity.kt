package com.kalpicapp.homeground

import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.timer_layout.*

class TimerActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.timer_layout)

        val timer = object: CountDownTimer( 5000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timertext.text = "onclick timer"
                timerbtn.text = millisUntilFinished.toString()
                timerbtn.setBackgroundColor(Color.BLUE)
            }

            override fun onFinish() {
                timertext.text = "on finish"
                timerbtn.setBackgroundColor(Color.GREEN)
            }
        }
        timerbtn.setOnClickListener {
            timer.start()

        }


    }
}