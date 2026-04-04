package kr.co.umc.nike.presentation.feat_home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.co.umc.nike.databinding.ItemNewGoodBinding
import kr.co.umc.nike.presentation.feat_home.model.NewGood

class NewGoodsRVAdapter(private val goodsList: MutableList<NewGood>)
    : RecyclerView.Adapter<NewGoodsViewHolder>() {
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
        val nowGood = goodsList[position]
        holder.bind(nowGood)
    }

    override fun getItemCount(): Int = goodsList.size
}
