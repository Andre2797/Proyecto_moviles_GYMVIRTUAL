package com.example.gymvirtual

import android.R
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PagerController: FragmentPagerAdapter {

    var numoftabs:Int=0

    constructor(fm: FragmentManager, behavior: Int) : super(fm, behavior){
        this.numoftabs=behavior
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> Frg_calendario()
            1 -> Frg_calendario()
            2 -> Frg_calendario()


            else -> Frg_calendario()
        }
    }

    override fun getCount(): Int {
        return numoftabs
    }

}