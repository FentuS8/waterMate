package com.example.watermate.custom_utils

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet

class CustomSeekBar : androidx.appcompat.widget.AppCompatSeekBar {
    private val paint = Paint()

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        paint.color = Color.RED
        canvas.drawCircle((width * 0.25).toFloat(), (height / 2).toFloat(), 10f, paint)
        canvas.drawCircle((width * 0.5).toFloat(), (height / 2).toFloat(), 10f, paint)
        canvas.drawCircle((width * 0.75).toFloat(), (height / 2).toFloat(), 10f, paint)
    }
}
