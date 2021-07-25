package com.noscale.cerberus.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.noscale.cerberus.R

/**
 * This fragment class is used as boiler plate;
 * Created by kurniawanrizzki on 11/06/21.
 */
open class BaseFragment: Fragment() {

    open var mLayoutResource: Int = R.layout.fragment_base

    private var baseActivity: BaseActivity<*, *>? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(mLayoutResource, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        baseActivity = activity as BaseActivity<*, *>
    }

    override fun onResume() {
        super.onResume()
        onPresent()
    }

    private fun onPresent () {
        if (this is BaseView<*>) {
            val v = this as BaseView<*>
            v?.mPresenter?.start()
        }
    }
}