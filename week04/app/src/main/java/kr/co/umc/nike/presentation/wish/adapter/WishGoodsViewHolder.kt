package kr.co.umc.nike.presentation.wish.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kr.co.umc.nike.databinding.ItemWishGoodBinding
import kr.co.umc.nike.presentation.wish.model.WishGood
import timber.log.Timber

class WishGoodsViewHolder(private val binding: ItemWishGoodBinding) :
    RecyclerView.ViewHolder(binding.root) {
        fun bind(good: WishGood) {
            binding.apply {
                ivWishGood.setImageResource(good.goodImage)
                tvWishGood.text = good.goodName
                tvWishGoodPrice.text = good.goodPrice
                tvWishGoodDescription.text = good.description
                tvWishGoodColorDescription.text = good.colorDescription

            }
            Timber.d("Timber: 리사이클러뷰 데이터 바인딩")
        }

}