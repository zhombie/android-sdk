package kz.zhombie.recyclerview

import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.disableChangeAnimations() {
    itemAnimator = null
}