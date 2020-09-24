package com.example.gymvirtual.Menus

import Activities_MenusOpciones.Act_Recetas
import Activities_MenusOpciones.adaptadorRecyclerView
import Modelo.RecetaHttp
import Modelo.ServicioBDDMemoria
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.beust.klaxon.Klaxon
import com.example.gymvirtual.Interfaces.goRecetas
import com.example.gymvirtual.R
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result

class Act_MenuPrincipalNutricion : AppCompatActivity(), goRecetas {

    var arrayImagenesURL = arrayListOf<String>()
    val urlPrincipal = "http://192.168.1.4:1337"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act__menu_principal_nutricion)

       var arrayReceta = arrayListReceta()
        arrayReceta.forEach {
            Log.i("RECETA", "Datos de la receta: ${it}")
        }
        initImageBitmaps(arrayReceta)
    }

    fun initImageBitmaps(arrayReceta: ArrayList<RecetaHttp>){
        /*arrayImagenesURL.add("http://gymvirtual.com/wp-content/uploads/2020/06/minpancakes-veganos-810x456.jpg")
        arrayImagenesURL.add("http://gymvirtual.com/wp-content/uploads/2020/06/PAN-DE-ESPECIAS-810x456.jpg")
        arrayImagenesURL.add("http://gymvirtual.com/wp-content/uploads/2020/06/COCA-DE-AN--S-810x456.jpg")*/
        arrayReceta.forEach {
            arrayImagenesURL.add(it.imagen_rec.toString())
        }
        initRecyclerView()
    }

    fun initRecyclerView(){
        var recyclerView: RecyclerView = findViewById(R.id.rv_menuPrincipal)
        var adaptador = adaptadorRecyclerView(this,arrayImagenesURL)
        recyclerView.setAdapter(adaptador)
        recyclerView.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)
        adaptador.notifyDataSetChanged()
    }

    override fun goRecetasItemClick(position: Int) {
        val intent = Intent(this, Act_Recetas::class.java)
        startActivity(intent)
    }

    fun arrayListReceta():ArrayList<RecetaHttp>{
        val url = urlPrincipal + "/receta"
        val recetaArray = arrayListOf<RecetaHttp>()
        var peticion = url.httpGet()
            .responseString { request, response, result ->
                when (result) {
                    is Result.Success -> {
                        val data = result.get()
                        val superheroes = Klaxon().converter(ServicioBDDMemoria.convertidorReceta())
                                .parseArray<RecetaHttp>(data)
                        if (superheroes != null) {
                            superheroes.forEach {
                                recetaArray.add(RecetaHttp(it.id,it.nombre_rec, it.imagen_rec, it.preparacion_rec, it.ingredientes))
                            }
                        }
                    }
                    is Result.Failure -> {
                        val error = result.getException()
                        Log.i("Error", "ERROR: ${error}")
                    }
                }
            }
        peticion.join()
        return recetaArray
    }
}