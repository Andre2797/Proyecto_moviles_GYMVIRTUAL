package com.example.gymvirtual

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_act__nombre__registro.*

class Act_Nombre_Registro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act__nombre__registro)
        btn_nombre.setOnClickListener(){
            abriredad()
        }
    }
    fun abriredad(){
        val intentExplicito = Intent(
            this,
            Act_edad_registro::class.java
        )
        startActivity(intentExplicito)
    }
}