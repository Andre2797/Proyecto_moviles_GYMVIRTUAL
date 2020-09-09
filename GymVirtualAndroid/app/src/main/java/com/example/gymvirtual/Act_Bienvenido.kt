package com.example.gymvirtual

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.result.Result
class Act_Bienvenido : AppCompatActivity() {
    var nombreCompartido: String ? = ""
    var edadCompartido: Int = 0
    var pesoCompartido : Double = 0.0
    var alturaCompartido:Double = 0.0
    var correoCompartido: String?= ""
    var sexoCompartido: String? = ""
    val urlGeneral = "http://192.168.1.103:1337"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act__bienvenido)
        sexoCompartido = intent.getStringExtra("sexo")
        nombreCompartido = intent.getStringExtra("nombre")
        pesoCompartido = intent.getDoubleExtra("peso",0.0)
        edadCompartido = intent.getIntExtra("edad", 0)
        alturaCompartido = intent.getDoubleExtra("altura",0.0)
        correoCompartido = intent.getStringExtra("correo")

        if(nombreCompartido != null){
            Log.i("Intent", "El nombre de usuario es: ${nombreCompartido}")
        }

        if(edadCompartido != null){
            Log.i("Intent", "La edad del usuario es: ${edadCompartido}")
        }

        if(alturaCompartido != null){
            Log.i("Intent", "La altura del usuario es: ${alturaCompartido}")
        }

        if(correoCompartido != null){
            Log.i("Intent", "El correo del usuario es: ${correoCompartido}")
        }

        if(sexoCompartido != null){
            Log.i("Intent", "El sexo de usuario es: ${sexoCompartido}")
        }

        val url = urlGeneral + "/usuario"
        val parametrosUsuario: List<Pair<String, String>> = listOf(
            "nombre_usu" to nombreCompartido.toString(),
            "edad_usu" to edadCompartido.toString(),
            "peso_usu" to pesoCompartido.toString(),
            "altura_usu" to alturaCompartido.toString(),
            "correo_usu" to correoCompartido.toString(),
            "sexo_usu" to sexoCompartido.toString(),
            "contrasenia_usu" to "123"
        )

        url.httpPost(parametrosUsuario).responseString { request, response, result ->
            when(result){
                is Result.Failure -> {
                 val error = result.getException()
                    Log.i("Error", "El error al crear usuario es: ${error}")
                }
                is Result.Success ->{
                    val usuarioString = result.get()
                    Log.i("Exitoso", "El exito al crear usuario es: ${usuarioString}")
                }
            }
        }
    }
}
