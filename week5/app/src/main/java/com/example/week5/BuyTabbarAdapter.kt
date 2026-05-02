package com.example.week5

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class BuyTabbarAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> BuyItemFragment.newInstance(null)      // 전체
            1 -> BuyItemFragment.newInstance("tops")    // Tops & T-Shirts
            2 -> BuyItemFragment.newInstance("sale")    // sale
            else -> BuyItemFragment.newInstance(null)
        }
    }
}