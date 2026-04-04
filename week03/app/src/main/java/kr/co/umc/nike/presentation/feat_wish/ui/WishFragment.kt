package kr.co.umc.nike.presentation.feat_wish.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kr.co.umc.nike.R
import kr.co.umc.nike.databinding.FragmentWishBinding
import kr.co.umc.nike.presentation.feat_wish.adapter.WishGoodsRVAdapter
import kr.co.umc.nike.presentation.feat_wish.adapter.WishGoodsRVDecorator
import kr.co.umc.nike.presentation.feat_wish.model.WishGood
import timber.log.Timber

class WishFragment : Fragment() {

    private var _binding: FragmentWishBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: WishGoodsRVAdapter
    private lateinit var decorator: WishGoodsRVDecorator


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWishBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setDummyData()
    }

    private fun setDummyData() {
        val goodsList = mutableListOf(
            WishGood(
                R.drawable.img_mid_socks,
                "Air Jordan 1 Mid",
                goodPrice = "US$125"
            ),
            WishGood(
                R.drawable.img_cushioned_shoes,
                "Nike Everyday Plus\nCushioned",
                "Training Ankle Socks (6 Pairs)",
                "5 Colours",
                "US$10"
            ),
        )

        adapter = WishGoodsRVAdapter()
        decorator = WishGoodsRVDecorator()

        binding.rvWishGoods.apply {
            adapter = this@WishFragment.adapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            addItemDecoration(decorator)
        }
        Timber.d("Timber: 리사이클러뷰에 어댑터 붙임")

        adapter.submitList(goodsList)
        Timber.d("Timber: 리스트 submit")

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}