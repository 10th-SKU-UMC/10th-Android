package com.example.week4

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.week4.databinding.FragmentBuyBinding
import com.google.android.material.tabs.TabLayoutMediator

class BuyFragment : Fragment(R.layout.fragment_buy) {

    private var _binding: FragmentBuyBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: BuyTabbarAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        android.util.Log.d("BuyFragmentCheck", "BuyFragment 실행됨")
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentBuyBinding.bind(view)

        adapter = BuyTabbarAdapter(this)
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "전체"
                1 -> "Top & T-Shirts"
                2 -> "Sale"
                else -> ""
            }
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}