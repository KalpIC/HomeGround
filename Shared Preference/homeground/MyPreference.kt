package com.kalpicapp.homeground

import android.content.Context

class MyPreference (context:Context){

    val PREFERENCE_NAME = "SharedPreferenceHighScore"
    val PREFERENCE_HIGHSCORE = "HighScore"

    var preference = context.getSharedPreferences(PREFERENCE_NAME,Context.MODE_PRIVATE)

    fun getHighScore():Int{
        return preference.getInt(PREFERENCE_HIGHSCORE,0)

    }

    fun setHighScore(hs:Int){
        val editor = preference.edit()
        editor.putInt(PREFERENCE_HIGHSCORE,hs)
        editor.apply()
    }


}
