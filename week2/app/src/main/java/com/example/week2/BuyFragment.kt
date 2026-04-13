package com.example.week2

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.week2.databinding.FragmentBuyBinding

class BuyFragment : Fragment(R.layout.fragment_buy) {

    private var _binding: FragmentBuyBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: BuyAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentBuyBinding.bind(view)

        val buyList = listOf(
            Data(R.drawable.socks, "Nike Everyday Plus Cushioned", "US$10"),
            Data(R.drawable.nikeelitecrew, "Nike Elite Crew", "US$16"),
            Data(R.drawable.air_force, "Nike Air Force 1'07", "US$115"),
            Data(R.drawable.jordanenkikeairforce, "Jordan ENike Air Force 1'07essentials", "US$115")
        )

        adapter = BuyAdapter(buyList)

        binding.itemlist.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.itemlist.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
