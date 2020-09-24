package com.example.gymvirtual.Menus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gymvirtual.MenusYFragmentos.PagerController

import com.example.gymvirtual.R

import kotlinx.android.synthetic.main.activity_actv_menu_principal.*
import com.google.android.material.tabs.TabLayoutMediator

class Actv_menu_principal : AppCompatActivity() {

    private  val adapter1 by lazy { PagerController(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actv_menu_principal)
        vp_menu.setAdapter(adapter1)
        val tabLayoutMediator = TabLayoutMediator(tab_menu,vp_menu,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                when(position){
                    0 -> {
                        tab.text = "Mensual"
                        tab.setIcon(R.drawable.calendario4)

                    }
                    1 -> {
                        tab.text = "Retos"
                        tab.setIcon(R.drawable.retos)

                    }
                    2 -> {
                        tab.text = "Nutrición"
                        tab.setIcon(R.drawable.nutricion)

                    }
                }
            })
        tabLayoutMediator.attach()
      /*  var menu:TabLayout=findViewById(R.id.tab_menu)
        var view:ViewPager=findViewById(R.id.vp_menu)
        //var tab1:TabItem=findViewById(R.id.calendario)
        //var tab2:TabItem=findViewById(R.id.retos)
       // var tab3:TabItem=findViewById(R.id.nutricion)
        var pageController=PagerController(supportFragmentManager,menu.tabCount)
        view.setAdapter(pageController)
        menu.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                view.currentItem = tab.position
                if(tab.position==0){
                    pageController.notifyDataSetChanged()
                }
                if(tab.position==1){
                    pageController.notifyDataSetChanged()
                }
                if(tab.position==2){
                    pageController.notifyDataSetChanged()
                }
            }


            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }

        })

        view.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(menu))

       */






    }
}