package com.wangle.happysing

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.wangle.happysing.voices.TextToSpeechUtils

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        TextToSpeechUtils.getInstance(this).speakText("I love you")
    }
}
