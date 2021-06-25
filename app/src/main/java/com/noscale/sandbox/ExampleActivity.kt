package com.noscale.sandbox

import com.noscale.cerberus.base.BaseActivity

/**
 * This class is used as example of library usage;
 * Created by kurniawanrizzki on 16/06/21.
 */
class ExampleActivity: BaseActivity<ExampleContract.View, ExampleContract.Presenter>() {

    override var mIllustrationSrc: Int? = R.raw.raw_progress

    override var mIllustrationTitle: Int? = R.string.app_name

    override var mIllustrationDescription: Int? = R.string.app_name

    override var mView: ExampleContract.View? = ExampleFragment.newInstance()

    override var mPresenter: ExampleContract.Presenter? = ExamplePresenter(mView)

}