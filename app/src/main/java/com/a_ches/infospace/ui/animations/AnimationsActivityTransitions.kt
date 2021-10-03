package com.a_ches.infospace.ui.animations

import android.os.Bundle
import android.transition.ArcMotion
import android.transition.ChangeBounds
import android.transition.Slide
import android.transition.TransitionManager
import android.view.Gravity
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.a_ches.infospace.R
import kotlinx.android.synthetic.main.activity_animations.*

class AnimationsActivityTransitions : AppCompatActivity(){

    private var textIsVisible = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animations)
        button_animate.setOnClickListener {
            TransitionManager.beginDelayedTransition(transitions_container)
            textIsVisible = !textIsVisible
            text.visibility = if (textIsVisible) View.VISIBLE else View.GONE

            //TransitionManager.beginDelayedTransition(transitions_container, Slide(Gravity.END))
            //Теперь текст появляется справа.
        }

        button_animate_two.setOnClickListener {
            TransitionManager.beginDelayedTransition(transitions_container, Slide(Gravity.END))
            textIsVisible = !textIsVisible
            text.visibility = if (textIsVisible) View.VISIBLE else View.GONE
        }



        button_shuffle.setOnClickListener {
            TransitionManager.beginDelayedTransition(transitions_container,Slide(Gravity.START) )
            textIsVisible = !textIsVisible
            text.visibility = if (textIsVisible) View.VISIBLE else View.GONE
        }


}
}



