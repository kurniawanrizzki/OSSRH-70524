package com.noscale.cerberus.base

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
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
        set(value) {
            field = value
            bindIllustrationSrc(field)
        }

    open var mIllustrationTitle: Int? = null
        set(value) {
            field = value
            bindIllustrationTitle(field)
        }

    open var mIllustrationDescription: Int? = null
        set(value) {
            field = value
            bindIllustrationDescription(field)
        }

    var showIllustration: Boolean = true
        set(value) {
            field = value
            bindIllustrationVisibility(field)
        }

    open var mArguments: Bundle? = null

    open var mView: V? = null

    open var mPresenter: P? = null

    var isDataMissing: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mLayoutResource)

        applyFragment()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putBoolean(SHOULD_LOAD_FROM_REPOSITORY, isDataMissing)
        super.onSaveInstanceState(outState)
    }

    private fun applyFragment () {
        mView?.let {
            val ft = supportFragmentManager.beginTransaction()
            ft.add(R.id.fr_base_container, it as BaseFragment).commit()
        }

        bindIllustrationSrc(mIllustrationSrc)
        bindIllustrationTitle(mIllustrationTitle)
        bindIllustrationDescription(mIllustrationDescription)
        bindIllustrationVisibility(showIllustration)
    }

    private fun bindIllustrationSrc (field: Int?) {
        val container = findViewById<ConstraintWithIllustrationLayout>(R.id.cwi_parent_id)
        container?.setIllustrationSrc(field)
    }

    private fun bindIllustrationTitle (field: Int?) {
        val container = findViewById<ConstraintWithIllustrationLayout>(R.id.cwi_parent_id)
        container?.setIllustrationTitle(field?.let { getString(it) })
    }

    private fun bindIllustrationDescription (field: Int?) {
        val container = findViewById<ConstraintWithIllustrationLayout>(R.id.cwi_parent_id)
        container?.setIllustrationDescription(field?.let { getString(it) })
    }

    private fun bindIllustrationVisibility (field: Boolean) {
        val container = findViewById<ConstraintWithIllustrationLayout>(R.id.cwi_parent_id)
        container?.setIllustrationVisibility(field)
    }

    protected fun shouldLoadFromRepository (outState: Bundle?): Boolean =
        outState?.getBoolean(SHOULD_LOAD_FROM_REPOSITORY) ?: true

    fun hideKeyboard (v: View) {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(v.applicationWindowToken, 0);
    }

    companion object {
        const val SHOULD_LOAD_FROM_REPOSITORY = "SHOULD_LOAD_FROM_REPOSITORY"
    }
}