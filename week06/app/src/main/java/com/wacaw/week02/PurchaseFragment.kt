package com.wacaw.week02

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.wacaw.week02.adapter.ProductAdapter
import com.wacaw.week02.data.database.ProductDatabase
import com.wacaw.week02.data.repository.ProductRepository
import com.wacaw.week02.databinding.FragmentPurchaseBinding
import com.wacaw.week02.viewmodel.PurchaseViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class PurchaseFragment : Fragment() {
    private var _binding: FragmentPurchaseBinding? = null
    private val binding get() = _binding!!

    private val viewModel: PurchaseViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPurchaseBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerViewProductProduct.layoutManager =
            GridLayoutManager(requireContext(), 2)

        viewModel.products.observe(viewLifecycleOwner) { products ->
            val adapter = ProductAdapter(products) { clickedProduct ->
                viewModel.toggleLike(clickedProduct.id, clickedProduct.isLiked)
            }
            binding.recyclerViewProductProduct.adapter = adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

