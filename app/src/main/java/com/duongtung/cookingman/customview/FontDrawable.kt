package com.duongtung.cookingman

import android.content.Context
import android.graphics.drawable.Drawable
import android.content.res.ColorStateList
import android.content.res.Resources
import android.text.Layout
import android.text.StaticLayout
import android.text.TextPaint
import android.util.TypedValue
import android.content.res.TypedArray
import android.graphics.*

class FontDrawable : Drawable{
    /* Resources for scaling values to the given device */
    private var mResources: Resources? = null
    /* Paint to hold most drawing primitives for the text */
    private var mTextPaint: TextPaint? = null
    /* Layout is used to measure and draw the text */
    private var mTextLayout: StaticLayout? = null
    /* Alignment of the text inside its bounds */
    private var mTextAlignment = Layout.Alignment.ALIGN_NORMAL
    /* Optional path on which to draw the text */
    private var mTextPath: Path? = null
    /* Stateful text color list */
    private var mTextColors: ColorStateList? = null
    /* Container for the bounds to be reported to widgets */
    private var mTextBounds: Rect? = null
    /* Text string to draw */
    private var mText = ""

    /* Attribute lists to pull default values from the current theme */
    private val themeAttributes = intArrayOf(android.R.attr.textAppearance)
    private val appearanceAttributes =
        intArrayOf(android.R.attr.textSize, android.R.attr.typeface, android.R.attr.textStyle, android.R.attr.textColor)
    constructor(context : Context, faIconRes : Int,  isSolid : Boolean,  isBrand: Boolean,light: Boolean) {
        init(context, faIconRes, isSolid, isBrand, light)
    }

    private fun init(context: Context, faIconRes: Int, isSolid: Boolean, isBrand: Boolean,light: Boolean) {
        //Used to load and scale resource items
        mResources = context.resources
        //Definition of this drawables size
        mTextBounds = Rect()
        //Paint to use for the text
        mTextPaint = TextPaint(Paint.ANTI_ALIAS_FLAG)
        mTextPaint!!.density = mResources!!.displayMetrics.density
        mTextPaint!!.setDither(true)

        var textSize = 15
        var textColor: ColorStateList? = null
        var styleIndex = -1
        var typefaceIndex = -1

        //Set default parameters from the current theme
        val a = context.theme.obtainStyledAttributes(themeAttributes)
        val appearanceId = a.getResourceId(0, -1)
        a.recycle()

        var ap: TypedArray? = null
        if (appearanceId != -1) {
            ap = context.obtainStyledAttributes(appearanceId, appearanceAttributes)
        }
        if (ap != null) {
            for (i in 0 until ap.indexCount) {
                val attr = ap.getIndex(i)
                when (attr) {
                    0 //Text Size
                    -> textSize = a.getDimensionPixelSize(attr, textSize)
                    1 //Typeface
                    -> typefaceIndex = a.getInt(attr, typefaceIndex)
                    2 //Text Style
                    -> styleIndex = a.getInt(attr, styleIndex)
                    3 //Text Color
                    -> textColor = a.getColorStateList(attr)
                    else -> {
                    }
                }
            }

            ap.recycle()
        }

        setTextColor(textColor ?: ColorStateList.valueOf(-0x1000000))
        setRawTextSize(textSize.toFloat())

        var tf: Typeface? = null
        if (isSolid) {
            tf = FontCache.get(context, FontCache.FA_FONT_SOLID)
        } else if (isBrand) {
            tf = FontCache.get(context, FontCache.FA_FONT_BRANDS)
        } else if (light){
            tf = FontCache.get(context, FontCache.FA_FONT_LIGHT)
        }
        else{
            tf = FontCache.get(context, FontCache.FA_FONT_REGULAR)
        }
        setTypeface(tf, styleIndex)
        setText(context.getString(faIconRes))
    }


    /**
     * Set the text that will be displayed
     *
     * @param text Text to display
     */
    fun setText(text: CharSequence?) {
        var text = text
        if (text == null) text = ""

        mText = text as String

        measureContent()
    }

    /**
     * Return the text currently being displayed
     */
    fun getText(): CharSequence {
        return mText
    }

    /**
     * Return the current text size, in pixels
     */
    fun getTextSize(): Float {
        return mTextPaint!!.getTextSize()
    }

    /**
     * Set the text size.  The value will be interpreted in "sp" units
     *
     * @param size Text size value, in sp
     */
    fun setTextSize(size: Float) {
        setTextSize(TypedValue.COMPLEX_UNIT_SP, size)
    }

    /**
     * Set the text size, using the supplied complex units
     *
     * @param unit Units for the text size, such as dp or sp
     * @param size Text size value
     */
    fun setTextSize(unit: Int, size: Float) {
        val dimension = TypedValue.applyDimension(
            unit, size,
            mResources!!.getDisplayMetrics()
        )
        setRawTextSize(dimension)
    }

    /*
     * Set the text size, in raw pixels
     */
    private fun setRawTextSize(size: Float) {
        if (size != mTextPaint!!.getTextSize()) {
            mTextPaint!!.setTextSize(size)

            measureContent()
        }
    }

    /**
     * Return the horizontal stretch factor of the text
     */
    fun getTextScaleX(): Float {
        return mTextPaint!!.getTextScaleX()
    }

    /**
     * Set the horizontal stretch factor of the text
     *
     * @param size Text scale factor
     */
    fun setTextScaleX(size: Float) {
        if (size != mTextPaint!!.getTextScaleX()) {
            mTextPaint!!.setTextScaleX(size)
            measureContent()
        }
    }

    /**
     * Return the current text alignment setting
     */
    fun getTextAlign(): Layout.Alignment {
        return mTextAlignment
    }

    /**
     * Set the text alignment.  The alignment itself is based on the text layout direction.
     * For LTR text NORMAL is left aligned and OPPOSITE is right aligned.
     * For RTL text, those alignments are reversed.
     *
     * @param align Text alignment value.  Should be set to one of:
     *
     *
     * [Layout.Alignment.ALIGN_NORMAL],
     * [Layout.Alignment.ALIGN_NORMAL],
     * [Layout.Alignment.ALIGN_OPPOSITE].
     */
    fun setTextAlign(align: Layout.Alignment) {
        if (mTextAlignment !== align) {
            mTextAlignment = align
            measureContent()
        }
    }

    /**
     * Sets the typeface and style in which the text should be displayed.
     * Note that not all Typeface families actually have bold and italic
     * variants, so you may need to use
     * [.setTypeface] to get the appearance
     * that you actually want.
     */
    fun setTypeface(tf: Typeface?) {
        if (mTextPaint!!.getTypeface() !== tf) {
            mTextPaint!!.setTypeface(tf)

            measureContent()
        }
    }

    /**
     * Sets the typeface and style in which the text should be displayed,
     * and turns on the fake bold and italic bits in the Paint if the
     * Typeface that you provided does not have all the bits in the
     * style that you specified.
     */
    fun setTypeface(tf: Typeface?, style: Int) {
        var tf = tf
        if (style > 0) {
            if (tf == null) {
                tf = Typeface.defaultFromStyle(style)
            } else {
                tf = Typeface.create(tf, style)
            }

            setTypeface(tf)
            // now compute what (if any) algorithmic styling is needed
            val typefaceStyle = tf?.style ?: 0
            val need = style and typefaceStyle.inv()
            mTextPaint!!.setFakeBoldText(need and Typeface.BOLD != 0)
            mTextPaint!!.setTextSkewX((if (need and Typeface.ITALIC != 0) -0.25f else 0) as Float)
        } else {
            mTextPaint!!.setFakeBoldText(false)
            mTextPaint!!.setTextSkewX(0f)
            setTypeface(tf)
        }
    }

    /**
     * Return the current typeface and style that the Paint
     * using for display.
     */
    fun getTypeface(): Typeface {
        return mTextPaint!!.getTypeface()
    }

    /**
     * Set a single text color for all states
     *
     * @param color Color value such as [Color.WHITE] or [Color.argb]
     */
    fun setTextColor(color: Int) {
        setTextColor(ColorStateList.valueOf(color))
    }

    /**
     * Set the text color as a state list
     *
     * @param colorStateList ColorStateList of text colors, such as inflated from an R.color resource
     */
    fun setTextColor(colorStateList: ColorStateList) {
        mTextColors = colorStateList
        updateTextColors(state)
    }

    /**
     * Optional Path object on which to draw the text.  If this is set,
     * FontDrawable cannot properly measure the bounds this drawable will need.
     * You must call [setBounds()][.setBounds] before
     * applying this FontDrawable to any View.
     *
     *
     * Calling this method with `null` will remove any Path currently attached.
     */
    fun setTextPath(path: Path) {
        if (mTextPath !== path) {
            mTextPath = path
            measureContent()
        }
    }

    /**
     * Internal method to take measurements of the current contents and apply
     * the correct bounds when possible.
     */
    private fun measureContent() {
        //If drawing to a path, we cannot measure intrinsic bounds
        //We must resly on setBounds being called externally
        if (mTextPath != null) {
            //Clear any previous measurement
            mTextLayout = null
            mTextBounds!!.setEmpty()
        } else {
            //Measure text bounds
            val desired = Math.ceil(Layout.getDesiredWidth(mText, mTextPaint).toDouble())
            mTextLayout = StaticLayout(
                mText, mTextPaint, desired.toInt(),
                mTextAlignment, 1.0f, 0.0f, false
            )
            mTextBounds!!.set(0, 0, mTextLayout!!.width, mTextLayout!!.height)
        }

        //We may need to be redrawn
        invalidateSelf()
    }

    /**
     * Internal method to apply the correct text color based on the drawable's state
     */
    private fun updateTextColors(stateSet: IntArray): Boolean {
        val newColor = mTextColors!!.getColorForState(stateSet, Color.WHITE)
        if (mTextPaint!!.getColor() !== newColor) {
            mTextPaint!!.setColor(newColor)
            return true
        }

        return false
    }

    override fun onBoundsChange(bounds: Rect) {
        //Update the internal bounds in response to any external requests
        mTextBounds!!.set(bounds)
    }

    override fun isStateful(): Boolean {
        /*
         * The drawable's ability to represent state is based on
         * the text color list set
         */
        return mTextColors!!.isStateful()
    }

    override fun onStateChange(state: IntArray): Boolean {
        //Upon state changes, grab the correct text color
        return updateTextColors(state)
    }

    override fun getIntrinsicHeight(): Int {
        //Return the vertical bounds measured, or -1 if none
        return if (mTextBounds!!.isEmpty()) {
            -1
        } else {
            mTextBounds!!.bottom - mTextBounds!!.top
        }
    }

    override fun getIntrinsicWidth(): Int {
        //Return the horizontal bounds measured, or -1 if none
        return if (mTextBounds!!.isEmpty()) {
            -1
        } else {
            mTextBounds!!.right - mTextBounds!!.left
        }
    }

    override fun draw(canvas: Canvas) {
        val bounds = bounds
        val count = canvas.save()
        canvas.translate(bounds.left.toFloat(), bounds.top.toFloat())
        if (mTextPath == null) {
            //Allow the layout to draw the text
            mTextLayout!!.draw(canvas)
        } else {
            //Draw directly on the canvas using the supplied path
            canvas.drawTextOnPath(mText, mTextPath!!, 0f, 0f, mTextPaint!!)
        }
        canvas.restoreToCount(count)
    }

    override fun setAlpha(alpha: Int) {
        if (mTextPaint!!.getAlpha() !== alpha) {
            mTextPaint!!.setAlpha(alpha)
        }
    }

    override fun getOpacity(): Int {
        return mTextPaint!!.getAlpha()
    }

    override fun setColorFilter(cf: ColorFilter?) {
        if (mTextPaint!!.getColorFilter() !== cf) {
            mTextPaint!!.setColorFilter(cf)
        }
    }
}