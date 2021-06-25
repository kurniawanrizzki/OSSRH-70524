package com.noscale.sandbox

import com.noscale.cerberus.base.BasePresenter
import com.noscale.cerberus.base.BaseView

/**
 * This class is used as example of library usage;
 * Created by kurniawanrizzki on 23/06/21.
 */
interface ExampleContract {
    interface View: BaseView<Presenter>

    interface Presenter: BasePresenter
}