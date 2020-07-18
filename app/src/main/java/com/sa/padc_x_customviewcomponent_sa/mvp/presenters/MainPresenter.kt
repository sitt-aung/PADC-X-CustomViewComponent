package com.sa.padc_x_customviewcomponent_sa.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.sa.padc_x_customviewcomponent_sa.delegates.NewsItemDelegate
import com.sa.padc_x_customviewcomponent_sa.mvp.views.MainView
import com.sa.padc_x_customviewcomponent_sa.views.viewpods.EmptyViewPod

interface MainPresenter : NewsItemDelegate, BasePresenter<MainView>, EmptyViewPod.Delegate {
    fun onSwipeRefresh(lifecycleOwner: LifecycleOwner)
    fun onUiReady(lifeCycleOwner: LifecycleOwner)
}