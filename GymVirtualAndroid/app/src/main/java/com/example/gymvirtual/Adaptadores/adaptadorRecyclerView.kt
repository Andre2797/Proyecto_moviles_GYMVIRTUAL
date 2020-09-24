package Activities_MenusOpciones

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gymvirtual.Interfaces.goRecetas
import com.example.gymvirtual.R

import kotlinx.android.synthetic.main.activity_act__menu_principal_nutricion.*

class adaptadorRecyclerView(
    var contexto : Context,
    var imagenes : ArrayList<String>
): RecyclerView.Adapter<adaptadorRecyclerView.MyViewHolder>() {

    inner class MyViewHolder(view: View):
        androidx.recyclerview.widget.RecyclerView.ViewHolder(view){
        var imagen:ImageView
        var parentLayout: RelativeLayout = view.findViewById(R.id.parent_layout)
        init{
            imagen = view.findViewById(R.id.iv_recyclerMenuComida)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int):
            MyViewHolder {
                val itemView = LayoutInflater.from(parent.context).inflate(R.layout.my_row,parent,false)
                return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return imagenes.size
    }

    override fun onBindViewHolder(
        holder: MyViewHolder,
        position: Int) {
        Glide.with(contexto)
            .asBitmap()
            .load(imagenes[position])
            .into(holder.imagen)
        holder.parentLayout.setOnClickListener {
          //goRecetas.goRecetasItemClick(position)
            //Toast.makeText(contexto, imagenes[position], Toast.LENGTH_SHORT).show()
            val intent: Intent = Intent(contexto, Act_Recetas::class.java)
            intent.putExtra("imagenURL", imagenes[position])
            contexto.startActivity(intent)
        }
    }
}

