package com.example.gymvirtual

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_act__sexo_login.*

class Act_SexoLogin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act__sexo_login)
        btn_sexoSig.setOnClickListener {
            abrirBienvenido()
        }
    }

    fun abrirBienvenido(){
        val intentExplicito = Intent(
            this,
            Act_Bienvenido::class.java
        )
        startActivity(intentExplicito)
    }
}
