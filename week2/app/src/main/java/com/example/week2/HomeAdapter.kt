package com.example.week2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.week2.databinding.ItemHomeBinding

class HomeAdapter(private val itemList: ArrayList<HomeData>) :
    RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    inner class HomeViewHolder(private val binding: ItemHomeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: HomeData) {
            binding.ivItemPhoto.setImageResource(data.imgRes)
            binding.tvItemTitle.text = data.title
            binding.tvItemPrice.text = data.price

            itemView.setOnClickListener {
                val activity = itemView.context as MainActivity

                val detailFragment = DetailFragment()
                val bundle = Bundle()
                bundle.putInt("image", data.imgRes)
                bundle.putString("title", data.title)
                detailFragment.arguments = bundle

                val bottomNav = activity.findViewById<com.google.android.material.bottomnavigation.BottomNavigationView>(R.id.bottom_navigation)
                bottomNav.menu.findItem(R.id.menu_buy).isChecked = true

                activity.supportFragmentManager.beginTransaction()
                    .replace(R.id.main_container, detailFragment)
                    .addToBackStack(null)
                    .commit()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val binding = ItemHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int = itemList.size
}