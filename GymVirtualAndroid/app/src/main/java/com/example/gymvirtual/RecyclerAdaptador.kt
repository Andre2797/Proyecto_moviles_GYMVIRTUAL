package com.example.gymvirtual

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RecyclerAdaptador(
    var contexto : Context,
    var titulos : ArrayList<String>,
    var imagenes : ArrayList<String>,
    var onCalendario: OnCalendario
):RecyclerView.Adapter<RecyclerAdaptador.MyViewHolder>() {

    lateinit var model:ArrayList<Retos>
    lateinit var lsitener:View.OnClickListener

    inner class MyViewHolder(view: View) :
        androidx.recyclerview.widget.RecyclerView.ViewHolder(view) {
        var titulo: TextView

        var imagen:ImageView
        var parentLayout:RelativeLayout= view.findViewById(R.id.id_relativeLayout)

        init {
            titulo = view.findViewById(R.id.titulo)

            imagen = view.findViewById(R.id.id_abdomen)
            view.setOnClickListener{
                val position:Int=adapterPosition

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView= LayoutInflater.from(parent.context)
            .inflate(R.layout.rv_retos,parent,false)

        return  MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return imagenes.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       //posision
        // val retos=listaretos[position]
        // holder.titulo.text =retos.titulo
        // holder.descripcion.text = retos.descripcion
        // holder.imagen.setImageResource(retos.imagen)
        Glide.with(contexto)
            .asBitmap()
            .load(imagenes[position])
            .into(holder.imagen)

        holder.titulo.setText(titulos[position])
        holder.parentLayout.setOnClickListener {
            onCalendario.onCalendarioItemClick(position)
        }
    }
}