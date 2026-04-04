package kr.co.umc.nike.presentation.feat_home.adapter

import androidx.recyclerview.widget.RecyclerView
import kr.co.umc.nike.databinding.ItemNewGoodBinding
import kr.co.umc.nike.presentation.feat_home.model.NewGood

class NewGoodsViewHolder(val binding: ItemNewGoodBinding) :
    RecyclerView.ViewHolder(binding.root) {
        fun bind(good: NewGood) {
            binding.apply {
                ivNewGood.setImageResource(good.goodImage)
                tvNewGood.text = good.goodName
                tvNewGoodPrice.text = good.goodPrice
            }
        }
}