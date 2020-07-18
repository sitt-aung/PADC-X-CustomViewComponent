package com.sa.padc_x_customviewcomponent_sa.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.sa.padc_x_customviewcomponent_sa.delegates.NewsItemDelegate
import com.sa.padc_x_customviewcomponent_sa.mvp.views.MainView

interface MainPresenter : NewsItemDelegate, BasePresenter<MainView> {
    fun onSwipeRefresh(lifecycleOwner: LifecycleOwner)
    fun onUiReady(lifeCycleOwner: LifecycleOwner)
}