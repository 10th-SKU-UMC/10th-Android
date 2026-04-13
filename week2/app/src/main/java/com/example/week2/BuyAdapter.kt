package com.example.week2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.week2.databinding.ListBuyBinding

class BuyAdapter(
    private val itemList: List<Data>
) : RecyclerView.Adapter<BuyAdapter.BuyViewHolder>() {

    inner class BuyViewHolder(
        private val binding: ListBuyBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Data) {
            binding.ivItemPhoto.setImageResource(item.imgRes)
            binding.tvItemName.text = item.title
            binding.tvItemPrice.text = item.price
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuyViewHolder {
        val binding = ListBuyBinding.inflate(
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