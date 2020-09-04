package com.example.gymvirtual

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_act_peso_registro.*

class Act_peso_registro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act_peso_registro)
        btn_peso.setOnClickListener{
            abrirAltura()
        }
    }

    fun abrirAltura(){
        val intentExplicito = Intent(
            this,
            Act_AlturaLogin::class.java
        )
        startActivity(intentExplicito)
    }
}