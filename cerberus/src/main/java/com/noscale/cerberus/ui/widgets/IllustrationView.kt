package com.noscale.cerberus.ui.widgets

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.airbnb.lottie.LottieAnimationView
import com.noscale.cerberus.R
import com.noscale.cerberus.ui.typography.ExtendedTextView

/**
 * The illustration described with title and description
 * Created by kurniawanrizzki on 11/06/21.
 */
class IllustrationView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    var mIllustrationSrc: Int = 0
        set(value) {
            field = value
            val lavImage = findViewById<LottieAnimationView>(R.id.lav_illustration_image)

            if (0 !== mIllustrationSrc) lavImage?.setAnimation(mIllustrationSrc)
        }

    var mIllustrationTitle: String? = null
        set(value) {
            field = value
            val etvTitle = findViewById<ExtendedTextView>(R.id.etv_illustration_title)

            etvTitle?.let { v -> mIllustrationTitle?.let {
                v.text = it
            }}
        }

    var mIllustrationDescription: String? = null
        set(value) {
            field = value
            val etvDescription = findViewById<ExtendedTextView>(R.id.etv_illustration_description)

            etvDescription?.let { v -> mIllustrationDescription?.let {
                v.text = it
            }}
        }

    init {
        initialization(attrs, defStyleAttr)
    }

    private fun initialization (attrs: AttributeSet?, defStyleAttr: Int) {
        val inflater = LayoutInflater.from(context)
        val ta = context.obtainStyledAttributes(attrs, R.styleable.IllustrationView, defStyleAttr, 0)

        inflater.inflate(R.layout.view_illustration, this)

        mIllustrationSrc = ta.getResourceId(R.styleable.IllustrationView_illustration_src, mIllustrationSrc)
        mIllustrationTitle = ta.getString(R.styleable.IllustrationView_illustration_title)
        mIllustrationDescription = ta.getString(R.styleable.IllustrationView_illustration_description)
    }

    fun applyResources (title: String?, desc: String?, src: Int?) {
        mIllustrationTitle = title
        mIllustrationDescription = desc

        src?.let { mIllustrationSrc = it }
    }
}