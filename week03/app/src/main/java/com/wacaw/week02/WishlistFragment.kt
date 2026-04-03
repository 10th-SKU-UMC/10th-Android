package com.wacaw.week02

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wacaw.week02.adapter.ProductAdapter
import com.wacaw.week02.data.ProductData


class WishlistFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_purchase, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 샘플 데이터
        val friendList = listOf(

            ProductData("Jordan ENike Air Force 1 '07ssentials", "Men's Shoes",R.drawable.image_sample_product_6,2,115),
            ProductData("Nike Everyday Plus Cushioned", "Training Ankle Socks (6 Pairs)",R.drawable.image_sample_product_3,5,10)
            )

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)

        // LayoutManager: 세로 리스트 형태
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)

        // Adapter 연결
        recyclerView.adapter = ProductAdapter(friendList)
    }


}