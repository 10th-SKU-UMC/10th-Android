package com.wacaw.week02

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wacaw.week02.adapter.ProductAdapter
import com.wacaw.week02.data.ProductData

class PurchaseFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_purchase, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 샘플 데이터
        val productList = listOf(
            ProductData("Nike Everyday Plus Cushioned", "Training Ankle Socks (6 Pairs)",R.drawable.image_sample_product_3,5,10),
            ProductData("Nike Elite Crew", "Basketball Socks",R.drawable.image_sample_product_4,7,16),
            ProductData("Nike Air Force 1 '07", "Women's Shoes",R.drawable.image_sample_product_5,5,115),
            ProductData("Jordan ENike Air Force 1 '07ssentials", "Men's Shoes",R.drawable.image_sample_product_6,2,115),

        )

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)

        recyclerView.adapter = ProductAdapter(productList)
    }

}