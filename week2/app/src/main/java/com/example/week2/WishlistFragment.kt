package com.example.week2

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.jvm.java

class WishlistFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: WishlistAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_wishlist, container, false)

        recyclerView = view.findViewById(R.id.recyclerView)

        val dummyList = listOf(
            Data(
                R.drawable.jordan1mid,
                "Air Jordan 1 Mid",
                "US$125",
                null
            ),
            Data(
                R.drawable.socks,
                "Nike Everyday Plus Cushioned",
                "US$10",
                null
            )
        )

        adapter = WishlistAdapter(dummyList) { item ->
            val bundle = Bundle().apply {
                putInt("image", item.imgRes)
                putString("title", item.title)
        }

            val detailFragment = DetailFragment().apply {
                arguments = bundle
            }

            val mainActivity = requireActivity() as MainActivity

            val bottomNav = mainActivity.findViewById<com.google.android.material.bottomnavigation.BottomNavigationView>(R.id.bottom_navigation)
            bottomNav.menu.findItem(R.id.menu_buy).isChecked = true

            mainActivity.supportFragmentManager.beginTransaction()
                .replace(R.id.main_container, detailFragment)
                .addToBackStack(null)
                .commit()
        }

        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        recyclerView.adapter = adapter

        return view
    }
}