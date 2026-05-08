package com.example.week5.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.week5.R
import com.example.week5.data.local.ProductEntity
import com.example.week5.databinding.ItemHomeBinding
import com.example.week5.ui.detail.DetailFragment
import com.example.week5.ui.main.MainActivity

class HomeAdapter(
    private val itemList: MutableList<ProductEntity> = mutableListOf()
) : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    inner class HomeViewHolder(private val binding: ItemHomeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: ProductEntity) {
            binding.ivItemPhoto.setImageResource(data.imgRes)
            binding.tvItemTitle.text = data.title
            binding.tvItemPrice.text = data.price

            itemView.setOnClickListener {
                val activity = itemView.context as MainActivity

                val detailFragment = DetailFragment().apply {
                    arguments = Bundle().apply {
                        putInt("id", data.id)
                        putInt("image", data.imgRes)
                        putString("title", data.title)
                        putString("price", data.price)
                        putString("description", data.description)
                    }
                }

                activity.binding.bottomNavigation.visibility = View.GONE

                activity.supportFragmentManager.beginTransaction()
                    .replace(R.id.main_container, detailFragment)
                    .addToBackStack(null)
                    .commit()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val binding = ItemHomeBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int = itemList.size

    fun submitList(newList: List<ProductEntity>) {
        itemList.clear()
        itemList.addAll(newList)
        notifyDataSetChanged()
    }
}
