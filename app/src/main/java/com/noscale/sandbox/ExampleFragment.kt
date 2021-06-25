package com.noscale.sandbox

import com.noscale.cerberus.base.BaseFragment

/**
 * This class is used as example of library usage;
 * Created by kurniawanrizzki on 23/06/21.
 */
class ExampleFragment: BaseFragment(), ExampleContract.View, BaseFragment.OnFragmentInteractionListener {
    override var mPresenter: ExampleContract.Presenter? = null

    override fun onInteract() {
        mPresenter?.start()
    }

    companion object {
        fun newInstance(): ExampleFragment = ExampleFragment()
    }
}