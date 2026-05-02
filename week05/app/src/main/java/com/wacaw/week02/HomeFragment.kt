package com.wacaw.week02

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.wacaw.week02.adapter.NewProductAdapter
import com.wacaw.week02.data.database.ProductDatabase
import com.wacaw.week02.data.repository.ProductRepository
import com.wacaw.week02.databinding.FragmentHomeBinding
import com.wacaw.week02.databinding.FragmentHomeBinding.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
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

        // 날짜 설정
        val dateString = LocalDateTime.now().format(
            DateTimeFormatter.ofPattern("M월 d일 E요일", Locale.KOREA)
        )
        binding.tvDate.text = getString(R.string.today_format, dateString)
        viewLifecycleOwner.lifecycleScope.launch {
            val db = ProductDatabase.getInstance(requireContext())
            val repository = ProductRepository(db.productDao(), db.categoryDao())

            val products = withContext(Dispatchers.IO) {
                repository.insertData()
                repository.getProductsByCategoryName("NewArrival")
            }

            withContext(Dispatchers.Main) {
                Log.d("DB", "상품 목록: $products")

                val adapter = NewProductAdapter(products)
                binding.recyclerViewNewProduct.adapter = adapter
            }
        }

        }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}