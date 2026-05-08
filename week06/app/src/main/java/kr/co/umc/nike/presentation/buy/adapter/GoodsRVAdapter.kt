package kr.co.umc.nike.presentation.buy.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import kr.co.umc.nike.databinding.ItemGoodBinding
import kr.co.umc.nike.presentation.buy.model.Good

class GoodsRVAdapter(private val onHeartClicked: (Good) -> Unit)
    : ListAdapter<Good, GoodsViewHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Good>() {
            override fun areItemsTheSame(
                oldItem: Good,
                newItem: Good
            ): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: Good,
                newItem: Good
            ): Boolean =
                oldItem == newItem

            override fun getChangePayload(oldItem: Good, newItem: Good): Any? {
                val diffBundle = Bundle()

                if (oldItem.isWished != newItem.isWished) {
                    diffBundle.putBoolean("isWished", newItem.isWished)
                }

                return if (diffBundle.isEmpty) null else diffBundle
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GoodsViewHolder {
        val binding = ItemGoodBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return GoodsViewHolder(binding, onHeartClicked)
    }

    override fun onBindViewHolder(
        holder: GoodsViewHolder,
        position: Int
    ) {
        holder.bind(getItem(position))
    }

    // 메서드 오버로딩 -> payload가 있을 경우
    override fun onBindViewHolder(
        holder: GoodsViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        if (payloads.isNotEmpty()) {
            val item = getItem(position)

            // 추후 장바구니 여부 같은 게 추가되어 payload에 들어갈 것들이 늘어날 수 있음. 이를 대비.
            val combinedBundle = Bundle()

            payloads.forEach {
                if (it is Bundle) combinedBundle.putAll(it)
            }

            if (combinedBundle.containsKey("isWished")) {
                holder.updateWish(item.isWished)
            }
        } else {
            holder.bind(getItem(position))
        }

    }
}