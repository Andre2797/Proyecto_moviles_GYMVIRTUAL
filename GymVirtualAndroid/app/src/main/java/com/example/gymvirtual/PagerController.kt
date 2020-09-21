package com.example.gymvirtual

import android.R
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter

class PagerController(fa:FragmentActivity): FragmentStateAdapter(fa) {

    companion object{
        private const val ARG_OBJECT="object"
    }
    override fun getItemCount(): Int =3

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> { frg_meses()}
            1 -> { Frg_calendario() }
            2 -> {Frg_nutricion()}
            else -> frg_meses()
        }
    }

    /*  var numoftabs:Int=0

      constructor(fm: FragmentManager, behavior: Int) : super(fm, behavior){
          this.numoftabs=behavior
      }

      override fun getItem(position: Int): Fragment {
          return when (position) {
              0 -> Frg_calendario()
              1 -> Frg_calendario()
              2 -> Frg_nutricion()


              else ->null
          }!!
      }

      override fun getCount(): Int {
          return numoftabs
      }

     */


}