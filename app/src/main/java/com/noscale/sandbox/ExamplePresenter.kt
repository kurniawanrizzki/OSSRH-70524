package com.noscale.sandbox

/**
 * This class is used as example of library usage;
 * Created by kurniawanrizzki on 23/06/21.
 */
class ExamplePresenter(
    mView: ExampleContract.View?
) : ExampleContract.Presenter {

    init {
        mView?.mPresenter = this
    }

    override fun start() {
    }
}