package kr.co.umc.nike.presentation.feat_buy.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import kr.co.umc.nike.databinding.ItemGoodBinding
import kr.co.umc.nike.presentation.feat_buy.model.Good

class GoodsRVAdapter()
    : ListAdapter<Good, GoodsViewHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Good>() {
            override fun areItemsTheSame(
                oldItem: Good,
                newItem: Good
            ): Boolean =
                oldItem.goodName == newItem.goodName

            override fun areContentsTheSame(
                oldItem: Good,
                newItem: Good
            ): Boolean =
                oldItem == newItem

        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GoodsViewHolder {
        val binding = ItemGoodBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return GoodsViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: GoodsViewHolder,
        position: Int
    ) {
        holder.bind(getItem(position))

    }
}