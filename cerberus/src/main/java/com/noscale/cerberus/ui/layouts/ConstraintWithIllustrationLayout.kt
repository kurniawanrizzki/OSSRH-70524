package com.noscale.cerberus.ui.layouts

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import com.noscale.cerberus.R
import com.noscale.cerberus.ui.widgets.IllustrationView

/**
 * Customable constraintLayout with illustration inside;
 * Created by kurniawanrizzki on 11/06/21.
 */
class ConstraintWithIllustrationLayout @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    init {
        initialization(attrs, defStyleAttr)
    }

    private fun initialization (attrs: AttributeSet?, defStyleAttr: Int) {
        id = R.id.cwi_parent_id
        val ta = context.obtainStyledAttributes(attrs, R.styleable.ConstraintWithIllustrationLayout, defStyleAttr, 0)

        var illustrationSrc = ta.getResourceId(R.styleable.ConstraintWithIllustrationLayout_illustration_src, 0)
        var illustrationTitle = ta.getString(R.styleable.ConstraintWithIllustrationLayout_illustration_title)
        var illustrationDescription = ta.getString(R.styleable.ConstraintWithIllustrationLayout_illustration_description)
        val illustrationVisibility = ta.getInt(R.styleable.ConstraintWithIllustrationLayout_illustration_visibility, VISIBLE)
        val containerVisibility = if (illustrationVisibility === VISIBLE) GONE else VISIBLE

        addIllustrationView(illustrationTitle, illustrationDescription, illustrationSrc, illustrationVisibility)
        addContainerView(containerVisibility)
    }

    private fun addIllustrationView (title: String?, description: String?, src: Int, visibility: Int) {
        val ivIllustration = IllustrationView(context)

        val illustrationParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
        illustrationParams.rightToRight = id
        illustrationParams.leftToLeft = id
        illustrationParams.topToTop = id
        illustrationParams.bottomToBottom = id

        ivIllustration.id = R.id.cwi_illustration_id
        ivIllustration.layoutParams = illustrationParams
        ivIllustration.visibility = visibility
        ivIllustration.applyResources(title, description, src)

        addView(ivIllustration)
    }

    private fun addContainerView (visibility: Int) {
        val clContainer = ConstraintLayout(context)
        val containerParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)

        clContainer.layoutParams = containerParams
        clContainer.id = R.id.cwi_container_id
        clContainer.visibility = visibility

        addView(clContainer)
    }

    fun setIllustrationSrc (src: Int?) {
        val ivIllustration = findViewById<IllustrationView>(R.id.cwi_illustration_id)
        src?.let { ivIllustration.mIllustrationSrc = it }
    }

    fun setIllustrationTitle (title: String?) {
        val ivIllustration = findViewById<IllustrationView>(R.id.cwi_illustration_id)
        ivIllustration.mIllustrationTitle = title
    }

    fun setIllustrationDescription (description: String?) {
        val ivIllustration = findViewById<IllustrationView>(R.id.cwi_illustration_id)
        ivIllustration.mIllustrationDescription = description
    }

    fun setIllustrationVisibility (show: Boolean) {
        val ivIllustration = findViewById<IllustrationView>(R.id.cwi_illustration_id)
        val container: ConstraintLayout = findViewById(R.id.cwi_container_id)

        ivIllustration.visibility = if (show) View.VISIBLE else View.GONE
        container.visibility = if (show) View.GONE else View.VISIBLE
    }

    override fun addView(child: View?, index: Int, params: ViewGroup.LayoutParams?) {
        val container: ConstraintLayout? = findViewById(R.id.cwi_container_id)

        container?.let {
            it.addView(child, index, params)
            return
        }

        super.addView(child, index, params)
    }
}