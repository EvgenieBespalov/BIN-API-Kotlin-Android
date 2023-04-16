package com.example.koin_compose_mvvm.screen

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class SectionsPageAdapter(fragment: FragmentActivity) : FragmentStateAdapter(fragment) {
    private var numFragment = true

    private var fragments = 0
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        val fragment: Fragment

        if (numFragment == true) {
            numFragment = false
            fragment = FindBinFragment()
        }
        else{
            numFragment = true
            fragment = BinHistoryFragment()
        }

        return fragment
    }

}