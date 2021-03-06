package com.a_ches.infospace.ui.animations

import android.os.Bundle
import android.transition.ArcMotion
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.view.Gravity
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.a_ches.infospace.R
import kotlinx.android.synthetic.main.activity_animations_path_transitions.*

class AnimationsActivityPath : AppCompatActivity() {


    private var toRightAnimation = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animations_path_transitions)
        button_path.setOnClickListener {
            val changeBounds = ChangeBounds()
            changeBounds.setPathMotion(ArcMotion())
            changeBounds.duration = 500
            TransitionManager.beginDelayedTransition(
                transitions_container,
                changeBounds
            )
            toRightAnimation = !toRightAnimation
            val params = button_path.layoutParams as FrameLayout.LayoutParams
            params.gravity =
                if (toRightAnimation) Gravity.END or Gravity.BOTTOM else
                    Gravity.START or Gravity.TOP
            button_path.layoutParams = params
        }
    }
}
