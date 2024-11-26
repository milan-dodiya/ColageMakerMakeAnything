package com.collagemaker_makeanything.Class

import android.content.Context
import android.graphics.*
import android.net.Uri
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.transition.Transition

class DrawingView(context: Context, attrs: AttributeSet?) : View(context, attrs) {
    private val drawPath = Path()
    private val drawPaint = Paint()
    private val canvasPaint = Paint(Paint.DITHER_FLAG)
    private lateinit var drawCanvas: Canvas
    private lateinit var canvasBitmap: Bitmap

    private var paintColor = Color.BLACK
    private var strokeWidth = 5f
    private var isEraser = false

    private var backgroundImage: Bitmap? = null
    private var eraserPosition = PointF()
    private var eraserRadius = 50f // Radius of the eraser circle

    init {
        setupDrawing()
    }

    private fun setupDrawing() {
        drawPaint.color = paintColor
        drawPaint.isAntiAlias = true
        drawPaint.strokeWidth = strokeWidth
        drawPaint.style = Paint.Style.STROKE
        drawPaint.strokeJoin = Paint.Join.ROUND
        drawPaint.strokeCap = Paint.Cap.ROUND
    }

    fun setColor(newColor: Int) {
        paintColor = newColor
        drawPaint.color = paintColor
        invalidate()  // Ensure view is redrawn with the new color
    }

    fun setEraser(eraser: Boolean) {
        isEraser = eraser
        if (isEraser) {
            // Set Xfermode to clear pixels for erasing
            drawPaint.xfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR)
        } else {
            // Restore default Xfermode and paint color for drawing
            drawPaint.xfermode = null
            drawPaint.color = paintColor
        }
        invalidate()  // Ensure view is redrawn with the new eraser settings
    }

    fun setStrokeWidth(newWidth: Float) {
        strokeWidth = newWidth
        drawPaint.strokeWidth = strokeWidth
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        canvasBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
        drawCanvas = Canvas(canvasBitmap)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        backgroundImage?.let {
            // Calculate position to center the image within the view
            val left = (width - it.width) / 2f
            val top = (height - it.height) / 2f
            canvas.drawBitmap(it, left, top, canvasPaint)
        }

        canvas.drawBitmap(canvasBitmap, 0f, 0f, canvasPaint)
        canvas.drawPath(drawPath, drawPaint)

        // Visualize the eraser circle without affecting the actual erasing
        if (isEraser) {
            val outerRingPaint = Paint().apply {
                color = Color.BLACK
                style = Paint.Style.STROKE
                strokeWidth = 5f
            }
            canvas.drawCircle(eraserPosition.x, eraserPosition.y, eraserRadius, outerRingPaint)

            val eraserCirclePaint = Paint().apply {
                color = Color.parseColor("#A9284BC4")
                style = Paint.Style.FILL
            }
            canvas.drawCircle(eraserPosition.x, eraserPosition.y, eraserRadius, eraserCirclePaint)
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        val touchX = event.x
        val touchY = event.y

        eraserPosition.set(touchX, touchY) // Update the eraser position

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                drawPath.moveTo(touchX, touchY)
            }
            MotionEvent.ACTION_MOVE -> {
                drawPath.lineTo(touchX, touchY)
            }
            MotionEvent.ACTION_UP -> {
                drawCanvas.drawPath(drawPath, drawPaint)
                drawPath.reset()
            }
            else -> return false
        }
        invalidate()
        return true
    }

    fun setBackgroundImage(imageUri: Uri) {
        Glide.with(context)
            .asBitmap()
            .load(imageUri)
            .into(object : SimpleTarget<Bitmap>() {
                override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                    backgroundImage = resource // Set the original bitmap without scaling
                    invalidate()
                }
            })
    }
}
