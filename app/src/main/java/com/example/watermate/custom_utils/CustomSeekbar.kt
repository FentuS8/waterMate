package com.example.watermate.custom_utils

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.SeekBar
import androidx.appcompat.widget.AppCompatSeekBar
import androidx.core.content.res.ResourcesCompat
import com.example.watermate.R

class CustomSeekbar : AppCompatSeekBar {
    private val paint = Paint()
    private var dotColor = Color.argb(200,79,79,79)
    private var textColor = Color.argb(200,30,30,30)
    private var maxValue = 2
    private var values = arrayOf(0, 1, 2)
    var labels: Array<String> = arrayOf("", "", "")

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle)

    init {
        setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val roundedProgress = getClosestValue(progress)
                if (progress != roundedProgress) {
                    seekBar?.progress = roundedProgress
                }
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val numDots = maxValue + 1
        val dotRadius = 12f
        val dotSpacing = (width - paddingLeft - paddingRight) / (numDots - 1)
        val centerY = height / 2f
        val textOffset = 40f

        for (i in 0 until numDots) {
            val centerX = (paddingLeft + i * dotSpacing).toFloat()
            val isSelected = progress == values[i]
            val dotColor = if (isSelected) Color.rgb(16, 192, 163) else dotColor

            paint.color = dotColor
            canvas.drawCircle(centerX, centerY, dotRadius, paint)
            val label = labels[i]
            val textWidth = paint.measureText(label)
            val textX = centerX - textWidth / 2
            val textY = centerY - dotRadius - textOffset
            paint.textSize = 45f
            paint.typeface = ResourcesCompat.getFont(context, R.font.samsungone400)
            paint.color = if (isSelected) Color.rgb(16, 192, 163) else textColor
            canvas.drawText(label, textX, textY, paint)
        }
    }

    private fun getClosestValue(value: Int): Int { return value.coerceIn(0, maxValue) }
}
