package kr.co.umc.nike.presentation.wish.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import kr.co.umc.nike.databinding.ItemWishGoodBinding
import kr.co.umc.nike.presentation.wish.model.WishGood

class WishGoodsRVAdapter()
    : ListAdapter<WishGood, WishGoodsViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<WishGood>() {
            override fun areItemsTheSame(
                oldItem: WishGood,
                newItem: WishGood
            ): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: WishGood,
                newItem: WishGood
            ): Boolean =
                oldItem == newItem
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WishGoodsViewHolder {
        val binding = ItemWishGoodBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return WishGoodsViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: WishGoodsViewHolder,
        position: Int
    ) {
        holder.bind(getItem(position))
    }

}