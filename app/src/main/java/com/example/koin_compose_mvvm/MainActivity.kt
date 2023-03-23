package com.example.koin_compose_mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
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

         //val viewPager = findViewById<ViewPager>(R.id.pager)
         //viewPager.adapter = SectionsPageAdapter(this)

         // Передаём ViewPager в TabLayout

         // Передаём ViewPager в TabLayout
         val tabLayout = findViewById<TabLayout>(R.id.tabs)
         //tabLayout.setupWithViewPager(viewPager)

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = "OBJECT ${(position + 1)}"
        }.attach()
    }
}