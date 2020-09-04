package com.example.gymvirtual

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_act_edad_registro.*

class Act_edad_registro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act_edad_registro)
        btn_edad.setOnClickListener{
            abrirPeso()
        }
    }

    fun abrirPeso(){
        val intentExplicito = Intent(
            this,
            Act_peso_registro::class.java
        )
        startActivity(intentExplicito)
    }
}