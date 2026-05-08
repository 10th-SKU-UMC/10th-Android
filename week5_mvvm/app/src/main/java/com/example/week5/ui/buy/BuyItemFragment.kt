package com.example.week5.ui.buy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.week5.databinding.FragmentBuyItemBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class BuyItemFragment : Fragment() {

    private var _binding: FragmentBuyItemBinding? = null
    private val binding get() = _binding!!

    private val viewModel: BuyItemViewModel by viewModels()

    private lateinit var adapter: BuyAdapter

    companion object {
        private const val ARG_CATEGORY = "category"

        fun newInstance(category: String?): BuyItemFragment {
            return BuyItemFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_CATEGORY, category)
                }
            }
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

        // ViewModel에 표시할 카테고리 알려주기
        viewModel.setCategory(arguments?.getString(ARG_CATEGORY))

        adapter = BuyAdapter(mutableListOf()) { item ->
            // 위시리스트 토글: ViewModel ▶ Repository ▶ DAO ▶ Flow가 자동 갱신
            viewModel.toggleWishlist(item)
        }

        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.recyclerView.adapter = adapter

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { state ->
                    adapter.submitList(state.products)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
