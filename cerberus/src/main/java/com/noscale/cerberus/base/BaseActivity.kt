package com.noscale.cerberus.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.noscale.cerberus.R
import com.noscale.cerberus.ui.layouts.ConstraintWithIllustrationLayout

/**
 * This activity class will be used as boiler plate;
 * Created by kurniawanrizzki on 11/06/21.
 */
open class BaseActivity<V: BaseView<P>, P: BasePresenter>: AppCompatActivity() {

    open var mLayoutResource: Int = R.layout.activity_base

    open var mIllustrationSrc: Int? = null

    open var mIllustrationTitle: Int? = null

    open var mIllustrationDescription: Int? = null

    open var mArguments: Bundle? = null

    open var mView: V? = null

    open var mPresenter: P? = null

    var isDataMissing: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mLayoutResource)

        applyIllustration()
        applyFragment()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putBoolean(SHOULD_LOAD_FROM_REPOSITORY, isDataMissing)
        super.onSaveInstanceState(outState)
    }

    fun showIllustration (show: Boolean) {
        val container = findViewById<ConstraintWithIllustrationLayout>(R.id.cwi_parent_id)
        container.setIllustrationVisibility(show)
    }

    fun applyIllustration () {
        val container = findViewById<ConstraintWithIllustrationLayout>(R.id.cwi_parent_id)

        container.setIllustrationTitle(mIllustrationTitle?.let { getString(it) })
        container.setIllustrationDescription(mIllustrationDescription?.let { getString(it) })
        container.setIllustrationSrc(mIllustrationSrc)
    }

    private fun applyFragment () {
        mView?.let {
            val ft = supportFragmentManager.beginTransaction()
            ft.add(R.id.fr_base_container, it as BaseFragment).commit()
        }
    }

    protected fun shouldLoadFromRepository (outState: Bundle?): Boolean =
        outState?.getBoolean(SHOULD_LOAD_FROM_REPOSITORY) ?: true

    companion object {
        const val SHOULD_LOAD_FROM_REPOSITORY = "SHOULD_LOAD_FROM_REPOSITORY"
    }
}