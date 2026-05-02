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

class NewProductAdapter(
    private val productList: List<ProductEntity>
) : RecyclerView.Adapter<NewProductAdapter.NewProductViewHolder>(){
    class NewProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvProductName: TextView = view.findViewById(R.id.tvNewProductName)
        val tvProductDetail: TextView = view.findViewById(R.id.tvNewProductDetail)
        val imgProduct: ImageView = view.findViewById(R.id.imgNewProduct)
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NewProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_new_product, parent, false)  // 변경
        return NewProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewProductViewHolder, position: Int) {
        val product = productList[position]
        holder.tvProductName.text = product.name
        holder.tvProductDetail.text = product.content
        holder.imgProduct.setImageResource(product.image_resource ?: R.drawable.ic_bagsimple)
    }

    override fun getItemCount(): Int {
        return productList.size
    }
}