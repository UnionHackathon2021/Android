package kr.hs.dgsw.unionhackathon.ui.decoration

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ItemDecoration(
    private val spaceSize: Int,
    private val orientation: Int = LinearLayoutManager.VERTICAL
) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect, view: View,
        parent: RecyclerView, state: RecyclerView.State
    ) {
        with(outRect) {
            if (orientation == LinearLayoutManager.HORIZONTAL) {
                if (parent.getChildAdapterPosition(view) == 0) {
                    left = spaceSize
                }
                right = spaceSize
                top = spaceSize
                bottom = spaceSize
            } else {
                if (parent.getChildAdapterPosition(view) == 0) {
                    top = spaceSize
                }
                bottom = spaceSize
                left = spaceSize
                right = spaceSize
            }
        }
    }
}