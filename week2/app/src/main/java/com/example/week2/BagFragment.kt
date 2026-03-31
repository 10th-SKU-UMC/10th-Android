package com.example.week2

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.week2.databinding.FragmentBagBinding

class BagFragment : Fragment(R.layout.fragment_bag) {
    private var _binding: FragmentBagBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentBagBinding.bind(view)

        binding.btnOrder.setOnClickListener {
            (activity as? MainActivity)?.changeFragment(R.id.menu_buy)
        }

        binding.btnOrder.setOnClickListener {
            val bottomNav = activity?.findViewById<com.google.android.material.bottomnavigation.BottomNavigationView>(R.id.bottom_navigation)
            bottomNav?.selectedItemId = R.id.menu_buy
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}