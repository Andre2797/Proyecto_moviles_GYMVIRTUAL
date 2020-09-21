package com.example.gymvirtual

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_act__nombre__registro.*
import kotlinx.android.synthetic.main.activity_act_edad_registro.*

class Act_edad_registro : AppCompatActivity() {
    var nombreCompartido: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act_edad_registro)

        /*if(nombreCompartido != null){
            Log.i("Intent", "El nombre de usuario es: ${nombreCompartido}")
        }*/
        btn_edad.setOnClickListener{
            enviarEdad()
        }
    }

    fun abrirPeso(){
        val intentExplicito = Intent(
            this,
            Act_peso_registro::class.java
        )
        startActivity(intentExplicito)
    }

    fun enviarEdad(){
        val intentExplicito = Intent(
            this,
            Act_peso_registro::class.java
        )
        nombreCompartido = intent.getStringExtra("nombre")
        intentExplicito.putExtra("edad", et_edad.text.toString().toInt())
        intentExplicito.putExtra("nombre",nombreCompartido )
        startActivity(intentExplicito)
    }
}