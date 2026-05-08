package kr.co.umc.nike.presentation.buy.adapter

import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import kr.co.umc.nike.R
import kr.co.umc.nike.databinding.ItemGoodBinding
import kr.co.umc.nike.presentation.buy.model.Good

class GoodsViewHolder(
    val binding: ItemGoodBinding,
    private val onHeartClicked: (Good) -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    private var currentItem: Good? = null

    // 뷰홀더 생성 시 클릭리스너 일괄 세팅
    init {
        binding.ivHeartInCircle.setOnClickListener {
            currentItem?.let { good ->
                onHeartClicked(good)
            }
        }
    }

    //전체 아이템 갱신시 호출할 메서드
    fun bind(good: Good) {
        currentItem = good

        binding.apply {

            ivHeartInCircle.apply {
                setImageResource(
                    if (good.isWished) R.drawable.filled_heart
                    else R.drawable.empty_heart
                )
            }

            tvBestSeller.isVisible = good.isBestSeller
            ivGood.setImageResource(good.goodImage)
            tvGood.text = good.goodName
            tvGoodDescription.text = good.goodDescription
            tvGoodColorDescription.text = good.colorDescription
            tvGoodPrice.text = good.goodPrice
        }
    }

    // 하트가 눌려졌을 때 호출될 메서드
    fun updateWish(isWished: Boolean) {
        currentItem = currentItem?.copy(isWished = isWished)

        binding.ivHeartInCircle.setImageResource(
            if (isWished) R.drawable.filled_heart
            else R.drawable.empty_heart
        )
    }

}