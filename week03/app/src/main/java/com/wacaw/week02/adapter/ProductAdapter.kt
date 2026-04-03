package com.wacaw.week02.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.wacaw.week02.R
import com.wacaw.week02.data.ProductData

class ProductAdapter(
    private val productList: List<ProductData>
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>(){

    class ProductViewHolder(view: View):RecyclerView.ViewHolder(view){
        val tvProductName: TextView = view.findViewById(R.id.tvProductName)
        val tvProductDetail: TextView = view.findViewById(R.id.tvProductDetail)
        val imgProduct: ImageView = view.findViewById(R.id.imgProduct)

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
        holder.tvProductName.text = product.name
        holder.tvProductDetail.text = product.detail
        holder.imgProduct.setImageResource(product.image)
    }

    override fun getItemCount(): Int {
        return productList.size
    }
}