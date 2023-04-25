package com.example.koin_compose_mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.koin_compose_mvvm.screen.SectionsPageAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: SectionsPageAdapter
    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        adapter = SectionsPageAdapter(this)

        viewPager = findViewById(R.id.pager)
        viewPager.adapter = adapter

        val tabLayout = findViewById<TabLayout>(R.id.tabs)

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = when(position){
                1 -> "Find BIN"
                else -> "History"
            }
        }.attach()
    }
}