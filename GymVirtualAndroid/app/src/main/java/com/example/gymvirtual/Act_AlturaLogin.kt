package com.example.gymvirtual

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_act__altura_login.*

class Act_AlturaLogin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act__altura_login)
        btn_alturaSig.setOnClickListener {
            abrirCorreoLogin()
        }
    }

    fun abrirCorreoLogin(){
        val intentExplicito = Intent(
            this,
            Act_CorreoLogin::class.java
        )
        startActivity(intentExplicito)
    }
}
