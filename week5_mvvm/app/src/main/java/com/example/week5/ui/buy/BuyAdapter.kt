package com.example.week5.ui.buy

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.week5.R
import com.example.week5.data.local.ProductEntity
import com.example.week5.databinding.ItemBuyBinding

class BuyAdapter(
    private val itemList: MutableList<ProductEntity> = mutableListOf(),
    private val onWishlistClick: (ProductEntity) -> Unit
) : RecyclerView.Adapter<BuyAdapter.BuyViewHolder>() {

    inner class BuyViewHolder(
        private val binding: ItemBuyBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ProductEntity) {
            binding.ivItemPhoto.setImageResource(item.imgRes)
            binding.tvItemName.text = item.title
            binding.tvItemPrice.text = item.price

            if (item.isWishlisted) {
                binding.ivWishlist.setImageResource(R.drawable.ic_fillheart)
            } else {
                binding.ivWishlist.setImageResource(R.drawable.ic_emptyheart)
            }

            binding.ivWishlist.setOnClickListener {
                onWishlistClick(item)
            }
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

    fun submitList(newList: List<ProductEntity>) {
        itemList.clear()
        itemList.addAll(newList)
        notifyDataSetChanged()
    }
}
