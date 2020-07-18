package com.sa.padc_x_customviewcomponent_sa.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.sa.padc_x_customviewcomponent_sa.mvp.views.NewsDetailsView

class NewsDetailsPresenterImpl : NewsDetailsPresenter, AbstractBasePresenter<NewsDetailsView>() {

    override fun onUiReady(lifeCycleOwner: LifecycleOwner, newsId: Int) {

    }
}