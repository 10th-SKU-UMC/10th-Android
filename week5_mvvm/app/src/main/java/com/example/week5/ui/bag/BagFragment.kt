package com.example.week5.ui.bag

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.week5.R
import com.example.week5.databinding.FragmentBagBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class BagFragment : Fragment(R.layout.fragment_bag) {

    private var _binding: FragmentBagBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentBagBinding.bind(view)

        binding.btnOrder.setOnClickListener {
            val bottomNav = activity?.findViewById<BottomNavigationView>(R.id.bottom_navigation)
            bottomNav?.selectedItemId = R.id.menu_buy
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
