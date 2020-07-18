package com.sa.padc_x_customviewcomponent_sa.mvp.presenters

import com.sa.padc_x_customviewcomponent_sa.mvp.views.BaseView

interface BasePresenter<T : BaseView> {
    fun initPresenter(view: T)
}