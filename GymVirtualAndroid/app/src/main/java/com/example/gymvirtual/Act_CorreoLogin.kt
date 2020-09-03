package com.example.gymvirtual

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_act__correo_login.*

class Act_CorreoLogin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act__correo_login)
        btn_correoSig.setOnClickListener {
            abrirSexoLogin()
        }
    }
fun abrirSexoLogin(){
    val intentExplicito = Intent(
        this,
        Act_SexoLogin::class.java
    )
    startActivity(intentExplicito)
}

}
