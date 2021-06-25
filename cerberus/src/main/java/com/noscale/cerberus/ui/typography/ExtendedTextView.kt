package com.noscale.cerberus.ui.typography

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import com.noscale.cerberus.R
import java.lang.Exception

/**
 * It's allowing the developer to define kind of typography directly into the layout;
 * Created by kurniawanrizzki on 16/06/21.
 */
class ExtendedTextView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : AppCompatTextView(context, attrs, defStyleAttr) {

    init {
        initialization(attrs, defStyleAttr)
    }

    private fun initialization (attrs: AttributeSet?, defStyleAttr: Int) {
        val ta: TypedArray = context.obtainStyledAttributes(attrs, R.styleable.ExtendedTextView, defStyleAttr, 0)
        val typography = ta.getInt(R.styleable.ExtendedTextView_typography, BODY_1)
        val textColor = ta.getColor(R.styleable.ExtendedTextView_android_textColor, ContextCompat.getColor(context, R.color.black))

        when (typography) {
            HEADLINE_1 -> applyStyle(R.string.light_font_style, R.style.TextAppearance_MaterialComponents_Headline1, textColor)
            HEADLINE_2 -> applyStyle(R.string.light_font_style, R.style.TextAppearance_MaterialComponents_Headline2, textColor)
            HEADLINE_3 -> applyStyle(R.string.normal_font_style, R.style.TextAppearance_MaterialComponents_Headline3, textColor)
            HEADLINE_4 -> applyStyle(R.string.normal_font_style, R.style.TextAppearance_MaterialComponents_Headline4, textColor)
            HEADLINE_5 -> applyStyle(R.string.normal_font_style, R.style.TextAppearance_MaterialComponents_Headline5, textColor)
            HEADLINE_6 -> applyStyle(R.string.medium_font_style, R.style.TextAppearance_MaterialComponents_Headline6, textColor)
            SUBTITLE_1 -> applyStyle(R.string.normal_font_style, R.style.TextAppearance_MaterialComponents_Subtitle1, textColor)
            SUBTITLE_2 -> applyStyle(R.string.medium_font_style, R.style.TextAppearance_MaterialComponents_Subtitle2, textColor)
            BODY_2 -> applyStyle(R.string.normal_font_style, R.style.TextAppearance_MaterialComponents_Body2, textColor)
            BUTTON -> applyStyle(R.string.medium_font_style, R.style.TextAppearance_MaterialComponents_Button, textColor)
            CAPTION -> applyStyle(R.string.normal_font_style, R.style.TextAppearance_MaterialComponents_Caption, textColor)
            OVERLINE -> applyStyle(R.string.normal_font_style, R.style.TextAppearance_MaterialComponents_Overline, textColor)
            else -> applyStyle(R.string.normal_font_style, R.style.TextAppearance_MaterialComponents_Body1, textColor)
        }
    }

    private fun applyStyle (fontAppearance: Int, textAppearance: Int, textColor: Int) {
        val customTypeface = getLightTypography(context, fontAppearance)
        setTextAppearance(textAppearance)
        setTextColor(textColor)

        customTypeface?.let {
            typeface = it
        }
    }

    companion object {
        const val HEADLINE_1 = 0x00
        const val HEADLINE_2 = 0x01
        const val HEADLINE_3 = 0x02
        const val HEADLINE_4 = 0x03
        const val HEADLINE_5 = 0x04
        const val HEADLINE_6 = 0x05
        const val SUBTITLE_1 = 0x06
        const val SUBTITLE_2 = 0x07
        const val BODY_1 = 0x08
        const val BODY_2 = 0x09
        const val BUTTON = 0x0A
        const val CAPTION = 0x0B
        const val OVERLINE = 0x0C

        fun getLightTypography (ctx: Context, resource: Int): Typeface? {
            try {
                return Typeface.createFromAsset(ctx.assets, ctx.getString(resource))
            } catch (e: Exception) {
                e.printStackTrace()
            }

            return null
        }
    }
}