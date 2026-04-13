package com.wacaw.week02

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wacaw.week02.adapter.NewProductAdapter
import com.wacaw.week02.adapter.ProductAdapter
import com.wacaw.week02.data.ProductData
import com.wacaw.week02.data.database.ProductDatabase
import com.wacaw.week02.data.repository.ProductRepository
import com.wacaw.week02.databinding.FragmentPurchaseBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PurchaseFragment : Fragment() {
    private var _binding: FragmentPurchaseBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPurchaseBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {
            val db = ProductDatabase.getInstance(requireContext())
            val repository = ProductRepository(db.productDao(), db.categoryDao())

            val products = withContext(Dispatchers.IO) {
                repository.insertData()
                repository.getAllProducts()
            }

            withContext(Dispatchers.Main) {
                Log.d("DB", "상품 목록: $products")

                binding.recyclerViewProduct.layoutManager = GridLayoutManager(requireContext(), 2)
                val adapter = ProductAdapter(products) { clickedProduct ->
                    // 하트 클릭 시
                    viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {
                        repository.updateLikeStatus(clickedProduct.id, clickedProduct.isLiked)

                        val check = repository.getAllProducts().find { it.id == clickedProduct.id }
                        Log.d("DB_CHECK", "DB 실제 상태: ${check?.isLiked}")
                    }
                }
                binding.recyclerViewProduct.adapter = adapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

