package kr.co.umc.nike.presentation.feat_buy.adapter

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class GoodsRVDecorator(private val spanCount: Int, private val space: Int): RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position = parent.getChildAdapterPosition(view)
        val column = position % spanCount // 현재 열 위치

        outRect.left = if (column == spanCount - 1) space else 0
        outRect.right = if (column == spanCount - 1) 0 else space

    }
}