package com.example.week4

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.week4.databinding.ItemBuyBinding

class BuyAdapter(
    private val itemList: List<Data>
) : RecyclerView.Adapter<BuyAdapter.BuyViewHolder>() {

    inner class BuyViewHolder(
        private val binding: ItemBuyBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Data) {
            binding.ivItemPhoto.setImageResource(item.imgRes)
            binding.tvItemName.text = item.title
            binding.tvItemPrice.text = item.price
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuyViewHolder {
        val binding = ItemBuyBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return BuyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BuyViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int = itemList.size
}