package com.sa.padc_x_customviewcomponent_sa.mvp.views

import com.sa.padc_x_customviewcomponent_sa.data.vos.NewsVO

interface MainView : BaseView{
    fun displayNewsList(newsList: List<NewsVO>)
    fun navigateToNewsDetails(newsId: Int)
    fun displayEmptyView()
    fun enableSwipeRefresh()
    fun disableSwipeRefresh()
}