package com.example.watermate.custom_utils

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.SeekBar
import androidx.appcompat.widget.AppCompatSeekBar
import com.example.watermate.R

class CustomSeekbar : AppCompatSeekBar {
    private val paint = Paint()
    private var dotColor = Color.argb(100, 79,79,79) // Цвет точек по умолчанию
    private var numDots = 3 // Количество точек по умолчанию

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        paint.color = dotColor
        val dotRadius = 10f
        val dotSpacing = (width - paddingLeft - paddingRight) / (numDots - 1)
        val centerY = height / 2f

        for (i in 0 until numDots) {
            val centerX = (paddingLeft + i * dotSpacing).toFloat()
            canvas.drawCircle(centerX, centerY, dotRadius, paint)
        }
    }
}

