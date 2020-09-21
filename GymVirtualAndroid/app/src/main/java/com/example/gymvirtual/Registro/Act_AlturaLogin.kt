package com.example.gymvirtual.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gymvirtual.Act_CorreoLogin
import com.example.gymvirtual.R
import kotlinx.android.synthetic.main.activity_act__altura_login.*

class Act_AlturaLogin : AppCompatActivity() {

    var nombreCompartido: String ? = ""
    var edadCompartido: Int = 0
    var pesoCompartido : Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act__altura_login)

        /*if(pesoCompartido != null){
            Log.i("Intent", "El peso del usuario es: ${pesoCompartido}")
        }*/
        btn_alturaSig.setOnClickListener {
           // abrirCorreoLogin()
            enviarAltura()
        }
    }

    fun abrirCorreoLogin(){
        val intentExplicito = Intent(
            this,
            Act_CorreoLogin::class.java
        )
        startActivity(intentExplicito)
    }
    fun enviarAltura(){
        val intentExplicito = Intent(
            this,
            Act_CorreoLogin::class.java
        )
        nombreCompartido = intent.getStringExtra("nombre")
        pesoCompartido = intent.getDoubleExtra("peso",0.0)
        edadCompartido = intent.getIntExtra("edad", 0)

        intentExplicito.putExtra("nombre",nombreCompartido)
        intentExplicito.putExtra("edad", edadCompartido)
        intentExplicito.putExtra("peso",pesoCompartido)
        intentExplicito.putExtra("altura", et_alturaLogin.text.toString().toDouble())
        startActivity(intentExplicito)
    }
}
