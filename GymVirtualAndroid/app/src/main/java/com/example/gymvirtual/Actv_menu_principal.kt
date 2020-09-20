package com.example.gymvirtual

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableLayout
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBar.TabListener
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabItem
import com.google.android.material.tabs.TabLayout

class Actv_menu_principal : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actv_menu_principal)
        var menu:TabLayout=findViewById(R.id.tab_menu)
        var view:ViewPager=findViewById(R.id.vp_menu)
        //var tab1:TabItem=findViewById(R.id.calendario)
        //var tab2:TabItem=findViewById(R.id.retos)
        //var tab3:TabItem=findViewById(R.id.nutricion)
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





    }
}