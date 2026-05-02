package com.example.week5

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.week5.R
import com.example.week5.databinding.FragmentDetailBinding

class DetailFragment : Fragment(R.layout.fragment_detail) {
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentDetailBinding.bind(view)

        arguments?.let {
            val imgRes = arguments?.getInt("image") ?: R.drawable.photo
            val title = arguments?.getString("title") ?: "상품명"

            binding.ivDetailPhoto.setImageResource(imgRes)
            binding.tvDetailTitle.text = title
        }
        binding.btnBack.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}