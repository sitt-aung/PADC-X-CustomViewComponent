package com.sa.padc_x_customviewcomponent_sa.mvp.presenters

import androidx.lifecycle.ViewModel
import com.sa.padc_x_customviewcomponent_sa.mvp.views.BaseView

abstract class AbstractBasePresenter<T : BaseView> : BasePresenter<T>, ViewModel() {
    var mView: T? = null

    override fun initPresenter(view: T) {
        mView = view
    }
}