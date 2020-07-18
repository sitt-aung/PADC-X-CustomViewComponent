package com.sa.padc_x_customviewcomponent_sa.mvp.views

import com.sa.padc_x_customviewcomponent_sa.data.vos.NewsVO

interface NewsDetailsView : BaseView {
    fun displayNewsDetails(news: NewsVO)
}