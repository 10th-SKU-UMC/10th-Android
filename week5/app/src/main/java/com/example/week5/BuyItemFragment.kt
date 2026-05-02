package com.example.week5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.week5.databinding.FragmentBuyItemBinding

class BuyItemFragment : Fragment() {

    private var _binding: FragmentBuyItemBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: BuyAdapter

    companion object {
        private const val ARG_CATEGORY = "category"

        fun newInstance(category: String?): BuyItemFragment {
            val fragment = BuyItemFragment()
            fragment.arguments = Bundle().apply {
                putString(ARG_CATEGORY, category)
            }
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBuyItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = BuyAdapter(mutableListOf()) { item ->
            Thread {
                val dao = ProductDatabase.getDatabase(requireContext()).productDao()
                val newState = !item.isWishlisted
                dao.updateWishlistState(item.id, newState)

                val updatedItem = item.copy(isWishlisted = newState)

                requireActivity().runOnUiThread {
                    adapter.updateItem(updatedItem)
                }
            }.start()
        }

        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.recyclerView.adapter = adapter

        loadProducts()
    }

    private fun loadProducts() {
        val category = arguments?.getString(ARG_CATEGORY)

        Thread {
            val dao = ProductDatabase.getDatabase(requireContext()).productDao()

            val productList = if (category.isNullOrEmpty()) {
                dao.getAllProducts()
            } else {
                dao.getProductsByCategory(category)
            }

            requireActivity().runOnUiThread {
                adapter.submitList(productList)
            }
        }.start()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}