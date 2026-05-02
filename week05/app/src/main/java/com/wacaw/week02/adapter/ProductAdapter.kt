package com.wacaw.week02.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.wacaw.week02.R
import com.wacaw.week02.data.ProductData
import com.wacaw.week02.data.entity.ProductEntity

class ProductAdapter(
    private val productList: List<ProductEntity>,
    private val onLikeClick: (ProductEntity) -> Unit
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>(){

    class ProductViewHolder(view: View):RecyclerView.ViewHolder(view){
        val tvProductName: TextView = view.findViewById(R.id.tvProductName)
        val tvProductDetail: TextView = view.findViewById(R.id.tvProductDetail)
        val imgProduct: ImageView = view.findViewById(R.id.imgProduct)
        val imgLike: ImageView = view.findViewById(R.id.imgLike)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]

        if (product.isLiked) {
            holder.imgLike.setImageResource(R.drawable.ic_heart_filled)
        } else {
            holder.imgLike.setImageResource(R.drawable.ic_heart_empty)
        }

        holder.tvProductName.text = product.name
        holder.tvProductDetail.text = product.content
        product.image_resource?.let {
            holder.imgProduct.setImageResource(it)
        }
        holder.imgLike.setOnClickListener {
            product.isLiked = !product.isLiked
            notifyItemChanged(position)
            onLikeClick(product)
        }
    }

    override fun getItemCount(): Int {
        return productList.size
    }
}