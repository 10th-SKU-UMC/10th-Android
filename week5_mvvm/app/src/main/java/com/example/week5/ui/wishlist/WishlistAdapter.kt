package com.example.week5.ui.wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.week5.R
import com.example.week5.data.local.ProductEntity

class WishlistAdapter(
    private val items: MutableList<ProductEntity> = mutableListOf(),
    private val onClick: (ProductEntity) -> Unit
) : RecyclerView.Adapter<WishlistAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val image = itemView.findViewById<ImageView>(R.id.iv_wish_photo)
        private val title = itemView.findViewById<TextView>(R.id.tv_wish_title)
        private val price = itemView.findViewById<TextView>(R.id.tv_wish_price)

        fun bind(item: ProductEntity) {
            image.setImageResource(item.imgRes)
            title.text = item.title
            price.text = item.price

            itemView.setOnClickListener {
                onClick(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_wishlist, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun submitList(newList: List<ProductEntity>) {
        items.clear()
        items.addAll(newList)
        notifyDataSetChanged()
    }
}
