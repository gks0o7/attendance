package com.example.attend.common.util

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class MarginVerticalItemDecoration(
    private val topMargin: Int = 0,
    private val bottomMargin: Int = 0,
    private val leftMargin: Int = 0,
    private val rightMargin: Int = 0
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        with(outRect) {
            if (parent.getChildAdapterPosition(view) % 4 == 0) {
                right = rightMargin
            }
            if (parent.getChildAdapterPosition(view) == 0) {
                top = topMargin
            }
            left = leftMargin
            bottom = bottomMargin
        }
    }
}