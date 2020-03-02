package com.egoriku.motionlayoutandroidacademy.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.motion.widget.TransitionAdapter
import com.egoriku.motionlayoutandroidacademy.R
import com.egoriku.motionlayoutandroidacademy.common.BundleDelegate
import com.egoriku.motionlayoutandroidacademy.common.LAYOUT_ID
import kotlinx.android.synthetic.main.scene_9_final.*

class MotionActivity : AppCompatActivity() {

    private val Bundle.layoutId: Int by BundleDelegate.Int(LAYOUT_ID)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layoutId = intent.extras?.layoutId ?: throw Exception("Where is layout??")

        setContentView(layoutId)

        if (layoutId == R.layout.scene_9_final) {
            motionLayout.setTransitionListener(object : TransitionAdapter() {

                override fun onTransitionChange(
                    layout: MotionLayout?,
                    startId: Int,
                    endId: Int,
                    progress: Float
                ) {
                    logo.isSelected = progress > 0.5
                }
            })
        }
    }
}
