package com.noscale.cerberus.base

/**
 * This interface is used as base of view usage
 * Created by kurniawanrizzki on 11/06/21.
 */
interface BaseView<T: BasePresenter> {
    var mPresenter: T?
}