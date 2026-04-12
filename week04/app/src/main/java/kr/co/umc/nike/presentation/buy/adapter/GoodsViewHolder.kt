package kr.co.umc.nike.presentation.buy.adapter

import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import kr.co.umc.nike.R
import kr.co.umc.nike.databinding.ItemGoodBinding
import kr.co.umc.nike.presentation.buy.model.Good

class GoodsViewHolder(val binding: ItemGoodBinding) :
    RecyclerView.ViewHolder(binding.root) {
        fun bind(good: Good, onHeartClicked: (Good) -> Unit) {
            binding.apply {

                ivHeartInCircle.apply {
                    setImageResource(
                        if (good.isWished) R.drawable.filled_heart
                        else R.drawable.empty_heart
                    )
                    setOnClickListener {
                        onHeartClicked(good)
                    }
                }

                tvBestSeller.isVisible = good.isBestSeller
                ivGood.setImageResource(good.goodImage)
                tvGood.text = good.goodName
                tvGoodDescription.text = good.goodDescription
                tvGoodColorDescription.text = good.colorDescription
                tvGoodPrice.text = good.goodPrice
            }
        }
}