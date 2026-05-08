package kr.co.umc.nike.presentation.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import kr.co.umc.nike.databinding.ItemNewGoodBinding
import kr.co.umc.nike.presentation.home.model.NewGood

class NewGoodsRVAdapter()
    : ListAdapter<NewGood, NewGoodsViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<NewGood>() {
            override fun areItemsTheSame(
                oldItem: NewGood,
                newItem: NewGood
            ): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: NewGood,
                newItem: NewGood
            ): Boolean =
                oldItem == newItem
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NewGoodsViewHolder {
        val binding = ItemNewGoodBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return NewGoodsViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: NewGoodsViewHolder,
        position: Int
    ) {
        holder.bind(getItem(position))
    }

}
