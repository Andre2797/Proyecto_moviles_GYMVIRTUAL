package com.example.gymvirtual.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import com.airbnb.lottie.LottieAnimationView
import com.example.gymvirtual.Actv_menu_principal
import com.example.gymvirtual.R
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.result.Result
import kotlinx.android.synthetic.main.activity_act__bienvenido.*

class Act_Bienvenido : AppCompatActivity() {
    var nombreCompartido: String ? = ""
    var edadCompartido: Int = 0
    var pesoCompartido : Double = 0.0
    var alturaCompartido:Double = 0.0
    var correoCompartido: String?= ""
    var sexoCompartido: String? = ""
    val urlGeneral = "http://192.168.1.103:1337"

    override fun onCreate(savedInstanceState: Bundle?) {

        var topAnimation: Animation
        var bottomAnimation: Animation
        var imagenMov : LottieAnimationView
        var textoBienvenido: ImageView
        var btn_continuar: Button
        var facebook: ImageView
        var instagram: ImageView
        var twitter: ImageView
        var youtube: ImageView

        super.onCreate(savedInstanceState)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)
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

        tv_nombreBienvenido.text = nombreCompartido.toString()

        //ANIMACIONES
        topAnimation = AnimationUtils.loadAnimation(this,
            R.anim.top_animation
        )
        bottomAnimation = AnimationUtils.loadAnimation(this,
            R.anim.bottom_animation
        )

        //HOOKS
        imagenMov  = findViewById(R.id.ilottie_gimnasio)
        textoBienvenido = findViewById(R.id.iv_bienvenido)
        btn_continuar = findViewById(R.id.btn_comenzar)
        facebook = findViewById(R.id.iv_facebook)
        instagram = findViewById(R.id.iv_instagram)
        twitter = findViewById(R.id.iv_twitter)
        youtube = findViewById(R.id.iv_youtube)

        imagenMov.setAnimation(topAnimation)
        textoBienvenido.setAnimation(bottomAnimation)
        btn_continuar.setAnimation(bottomAnimation)

        facebook.setAnimation(bottomAnimation)
        instagram.setAnimation(topAnimation)
        twitter.setAnimation(bottomAnimation)
        youtube.setAnimation(topAnimation)

        btn_comenzar.setOnClickListener {
            abrirmenu()
        }
    }

    fun abrirmenu(){
        val intentExplicito = Intent(
            this,
            Actv_menu_principal::class.java

        )
        startActivity(intentExplicito)
    }
}
