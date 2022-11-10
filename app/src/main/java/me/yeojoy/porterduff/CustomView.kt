package me.yeojoy.porterduff

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.View

class CustomView(context: Context, attrs: AttributeSet?, defStyle: Int) : View(context, attrs, defStyle) {
    constructor(context: Context) : this(context, null, 0)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    private val renderer = Renderer()
    var porterDuffMode: PorterDuff.Mode = PorterDuff.Mode.SCREEN
        set(value) {
            field = value
            Log.d("CustomView", "field: $field")
            renderer.porterDuffMode = value
            invalidate()
        }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        renderer.setWidthAndHeight(measuredWidth, measuredHeight)
    }

    override fun onDraw(canvas: Canvas) {
        renderer.onDraw(canvas)
    }

    class Renderer {
        private var width: Int = 0
        private var height: Int = 0
        private var centerX: Int = 0
        private var centerY: Int = 0

        var porterDuffMode: PorterDuff.Mode = PorterDuff.Mode.SCREEN

        fun setWidthAndHeight(width: Int, height: Int) {
            this.width = width
            this.height = height
            centerX = width/2
            centerY = height/2
        }

        fun onDraw(canvas: Canvas) {
            drawPorterDuffSample(canvas)
        }

        private fun drawPorterDuffSample(canvas: Canvas) {
            val sampleBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
            val sampleCanvas = Canvas(sampleBitmap)

            sampleCanvas.drawBitmap(getCircleBitmap(), 0f, 0f, Paint())
            sampleCanvas.drawBitmap(getRectangleBitmap(), 0f, 0f, Paint().apply {
                xfermode = PorterDuffXfermode(/*PorterDuff.Mode.SCREEN*/porterDuffMode)
            })

            canvas.drawBitmap(sampleBitmap, 0f, 0f, Paint())
        }

        private fun getCircleBitmap() = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888).apply {
            val canvas = Canvas(this)
            val paint = Paint().apply {
                flags = Paint.ANTI_ALIAS_FLAG
                color = Color.parseColor("#E9B639")
            }
            val radius = width * 3.5f / 10

            canvas.drawCircle(radius, radius, radius, paint)
        }

        private fun getRectangleBitmap() = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888).apply {
            val canvas = Canvas(this)
            val paint = Paint().apply {
                flags = Paint.ANTI_ALIAS_FLAG
                color = Color.parseColor("#4899C5")
            }
            val startTop = width * 3/10
            val endBottom = width * 9/10

            canvas.drawRect(
                Rect(startTop, startTop, endBottom, endBottom),
                paint
            )
        }
    }
}
