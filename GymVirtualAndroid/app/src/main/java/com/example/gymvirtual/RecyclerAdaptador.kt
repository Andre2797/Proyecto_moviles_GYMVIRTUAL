package com.example.gymvirtual

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdaptador(private val listaretos: List<Retos>,
                        private val contexto: Context?,
                        private val recyclerView: RecyclerView
):RecyclerView.Adapter<RecyclerAdaptador.MyViewHolder>() {

    lateinit var model:ArrayList<Retos>
    lateinit var lsitener:View.OnClickListener

    inner class MyViewHolder(view: View) :
        androidx.recyclerview.widget.RecyclerView.ViewHolder(view) {
        var titulo: TextView
        var descripcion: TextView
        var imagen:ImageView
        init {
            titulo = view.findViewById(R.id.titulo)
            descripcion = view.findViewById(R.id.descripcion)
            imagen = view.findViewById(R.id.id_abdomen)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView= LayoutInflater.from(parent.context)
            .inflate(R.layout.rv_retos,parent,false)// recursos del adaptador
        itemView.setOnClickListener(this.lsitener)
        return  MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return model.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       //posision
             val retos=listaretos[position]
           holder.titulo.text =retos.titulo
           holder.descripcion.text = retos.descripcion
          holder.imagen.setImageResource(retos.imagen)
    }
}