package kz.garage.samples.animation

import kz.garage.R
import kz.garage.Sample
import kz.garage.activity.intent.createIntent
import kz.garage.kotlin.simpleNameOf
import kz.garage.samples.BaseNestedModuleActivity
import kz.garage.samples.animation.scale.ScaleAnimationActivity

class AnimationActivity : BaseNestedModuleActivity() {

    companion object {
        private val TAG = simpleNameOf<AnimationActivity>()
    }

    override fun getLayoutId(): Int = R.layout.activity_animation

    override fun getHeaderTitle(): String = "Animation"

    override fun getSamples(): List<Sample> =
        listOf(
            Sample("scale", "Scale", null),
        )

    override fun onSampleClicked(sample: Sample) {
        when (sample.id) {
            "scale" ->
                startActivity(createIntent<ScaleAnimationActivity>())
        }
    }

}