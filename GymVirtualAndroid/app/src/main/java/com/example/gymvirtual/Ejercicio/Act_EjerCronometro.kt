package com.example.gymvirtual.Ejercicio

import android.os.Bundle
import android.os.Handler
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.gymvirtual.R

class  Act_EjerCronometro : AppCompatActivity() {

    lateinit var progressBar: ProgressBar
    lateinit var progressText: TextView
    var i = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act__ejer_cronometro)
        progressBar = findViewById(R.id.progress_bar)
        progressText = findViewById(R.id.progress_text)
        val handler: Handler = Handler()
        handler.postDelayed(object : Runnable {
            override fun run() {
                if (i <= 30) {
                    progressText.text = "" + i
                    progressBar.progress = i
                    i++
                    handler.postDelayed(this, 200)
                } else {
                    handler.removeCallbacks(this)
                }
            }
        }, 200)
    }



}