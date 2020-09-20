package com.example.gymvirtual

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_frg_calendario.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Frg_calendario.newInstance] factory method to
 * create an instance of this fragment.
 */
class Frg_calendario : Fragment() {
      var listaRetos= arrayListOf<Retos>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var vista:View=inflater.inflate(R.layout.fragment_frg_calendario, container, false)
        // Inflate the layout for this fragment

      cargarLista()
        Log.i("lista_retos",listaRetos.toString())

        iniciarRecycleView(
            listaRetos,requireActivity(),rv_retos_frg!!
        )

        return vista
    }

    fun cargarLista(){
        listaRetos.add(Retos("Abdominales","Con el fin de tonificar los músculos de la zona se deben realizar ejercicios abdominales.", R.drawable.abdomen))
        listaRetos.add(Retos("Piernas","Es un movimiento en el que participan una gran cantidad de músculos como, por ejemplo, los glúteos y los cuádriceps.", R.drawable.piernas))
        listaRetos.add(Retos("Abdominales","Se conoce como flexión la acción de doblar el cuerpo o alguno de sus miembros. Es, por lo tanto, un movimiento de aproximación entre partes del cuerpo mediante la acción de los músculos.", R.drawable.brazos))


    }
    fun iniciarRecycleView(
        listaRetos:ArrayList<Retos>,
        actividad: Context?,
        recyclerview: RecyclerView
    ){
        val adaptador=RecyclerAdaptador(
            listaRetos,
            requireActivity(),
            recyclerview
        )
        rv_retos_frg.adapter=adaptador
        rv_retos_frg.itemAnimator=androidx.recyclerview.widget.DefaultItemAnimator()
        rv_retos_frg.layoutManager=androidx.recyclerview.widget.LinearLayoutManager(requireActivity())
        adaptador.notifyDataSetChanged()
    }


}