package com.example.myapplication

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout

class InputView(context: Context, attributeSet: AttributeSet) :
    LinearLayout(context, attributeSet) {
    private var realHeight: Int = 0

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        realHeight = measuredHeight
        if (EXPAND_TO_WINDOW && MeasureSpec.getMode(heightMeasureSpec) == MeasureSpec.AT_MOST) {
            setMeasuredDimension(measuredWidth, MeasureSpec.getSize(heightMeasureSpec))
        }
    }

    fun getTopInsets(): Int {
        return measuredHeight - realHeight
    }

    companion object {
        private const val EXPAND_TO_WINDOW: Boolean = true
    }
}