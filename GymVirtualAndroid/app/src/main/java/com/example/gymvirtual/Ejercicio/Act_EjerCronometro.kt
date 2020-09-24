package com.example.gymvirtual.Ejercicio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.widget.Chronometer
import android.widget.Toast
import com.example.gymvirtual.R

class Act_EjerCronometro : AppCompatActivity() {
    var cronometro : Chronometer
    init{
        cronometro = findViewById(R.id.cr_cronometroEjercicio)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act__ejer_cronometro)


    }

    /*override onChronometerTick(var cronometro: Chronometer){
        var result: Long = SystemClock.elapsedRealtime()-chronometer.getBase()
        Toast.makeText(this, "time" + result),
    }*/


}