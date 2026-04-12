package kr.co.umc.nike.presentation.buy.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import kr.co.umc.nike.databinding.ItemGoodBinding
import kr.co.umc.nike.presentation.buy.model.Good

class GoodsRVAdapter(private val onHeartClicked: (Good) -> Unit)
    : ListAdapter<Good, GoodsViewHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Good>() {
            override fun areItemsTheSame(
                oldItem: Good,
                newItem: Good
            ): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: Good,
                newItem: Good
            ): Boolean =
                oldItem == newItem

            override fun getChangePayload(oldItem: Good, newItem: Good): Any? {
                return if (oldItem.isWished != newItem.isWished) true else null
            }

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
        holder.bind(getItem(position), onHeartClicked)

    }
}