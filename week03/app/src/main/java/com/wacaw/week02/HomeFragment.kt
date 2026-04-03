package com.wacaw.week02

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wacaw.week02.adapter.NewProductAdapter
import com.wacaw.week02.data.ProductData
import com.wacaw.week02.databinding.FragmentHomeBinding
import com.wacaw.week02.databinding.FragmentHomeBinding.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 샘플 데이터
        val productList = listOf(
            ProductData("Air Jordan XXXVI", "US$185",R.drawable.img_sample_product_1,0,0),
            ProductData("Nike Air Force 1 '07", "US$115",R.drawable.img_sample_product_2,0,0),
        )

        val dateString = LocalDateTime.now().format(
            DateTimeFormatter.ofPattern("M월 d일 E요일", Locale.KOREA)
        )
        binding.tvDate.text = getString(R.string.today_format, dateString)

        val recyclerView = view.findViewById< RecyclerView>(R.id.recyclerViewNewProduct)

        recyclerView.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.HORIZONTAL,
            false
        )
        recyclerView.adapter = NewProductAdapter(productList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}