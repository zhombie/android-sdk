package kz.garage.animation.funhouse.method.internal.zoom.exit

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.view.View
import android.view.ViewGroup
import kz.garage.animation.funhouse.method.base.BaseAnimation

internal class ZoomOutRight : BaseAnimation() {

    override fun describe(view: View): AnimatorSet {
        val parent = view.parent
        val distance = if (parent is ViewGroup) parent.height - view.top else view.top
        return createAnimatorSet().apply {
            playTogether(
                ObjectAnimator.ofFloat(view, "alpha", 1F, 1F, 0F),
                ObjectAnimator.ofFloat(view, "scaleX", 1F, 0.475F, 0.1F),
                ObjectAnimator.ofFloat(view, "scaleY", 1F, 0.475F, 0.1F),
                ObjectAnimator.ofFloat(view, "translationX", 0F, -42F, distance.toFloat())
            )
        }
    }

}