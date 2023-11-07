package com.lutech.aiart.extentionFunction

import android.animation.Animator
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.os.Handler
import android.util.Log
import android.view.View
import android.view.animation.Animation
import com.pdt.blockchainid.utils.Constants

fun View.zoomInOutInfiniteExt(view: View){
    val anim = ValueAnimator.ofFloat(1f, 1.1f)
    anim.duration = 1000
    anim.addUpdateListener { animation ->
        view.scaleX = animation.animatedValue as Float
        view.scaleY = animation.animatedValue as Float
    }
    anim.repeatCount = Animation.INFINITE
    anim.repeatMode = ValueAnimator.REVERSE
    anim.start()
}

fun View.vibrateMoveLeftRightExt(view: View){
    val rotate = ObjectAnimator.ofFloat(
        view,
        "translationX",
        0f,
        20f,
        0f,
        -20f,
        0f
    ) // rotate o degree then 20 degree and so on for one loop of rotation.
    rotate.repeatCount = Animation.INFINITE // repeat the loop 20 times
    rotate.duration = 400 // animation play time 100 ms
    rotate.addListener(object: Animator.AnimatorListener {
        override fun onAnimationStart(animation: Animator) {

        }

        override fun onAnimationEnd(animation: Animator) {

        }

        override fun onAnimationCancel(animation: Animator) {

        }

        override fun onAnimationRepeat(animation: Animator) {
            Log.d(Constants.DEBUG_LOG, "onAnimationRepeat")
            rotate.pause()
            val handler = Handler()
            handler.postDelayed(
                Runnable {
                    rotate.start()
                },
                1500
            )
        }
    })
    rotate.start()
}

