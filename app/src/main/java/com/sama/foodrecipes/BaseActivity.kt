package com.sama.foodrecipes

import android.view.View
import android.widget.FrameLayout
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.sama.foodrecipes.util.HorizontalDottedProgress


abstract class BaseActivity : AppCompatActivity() {

    var mProgressBar: HorizontalDottedProgress? = null

    override fun setContentView(layoutResID: Int) {

        val constraintLayout =
            layoutInflater.inflate(R.layout.activity_base, null) as ConstraintLayout
        val frameLayout = constraintLayout.findViewById<FrameLayout>(R.id.activity_content)
        mProgressBar = constraintLayout.findViewById(R.id.progress)
        layoutInflater.inflate(layoutResID, frameLayout, true)
        super.setContentView(constraintLayout)

    }

    fun showProgressBar(visibility: Boolean) {
        mProgressBar!!.visibility = if (visibility) View.VISIBLE else View.GONE
    }


}