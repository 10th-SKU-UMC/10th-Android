package kr.co.umc.nike.presentation.feat_wish.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kr.co.umc.nike.databinding.ItemWishGoodBinding
import kr.co.umc.nike.presentation.feat_wish.model.WishGood
import timber.log.Timber

class WishGoodsViewHolder(private val binding: ItemWishGoodBinding) :
    RecyclerView.ViewHolder(binding.root) {
        fun bind(good: WishGood) {
            binding.apply {
                ivWishGood.setImageResource(good.goodImage)
                tvWishGood.text = good.goodName
                tvWishGoodPrice.text = good.goodPrice

                tvWishGoodDescription.apply {
                    text = good.description
                    visibility = if (good.description != null) View.VISIBLE else View.GONE
                }

                tvWishGoodColorDescription.apply {
                    text = good.colorDescription
                    visibility = if (good.colorDescription != null) View.VISIBLE else View.GONE
                }
            }
            Timber.d("Timber: 리사이클러뷰 데이터 바인딩")
        }

}