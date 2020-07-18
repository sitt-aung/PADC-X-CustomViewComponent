package com.sa.padc_x_customviewcomponent_sa.delegates

import com.sa.padc_x_customviewcomponent_sa.views.viewpods.ReactionViewPod

interface NewsItemDelegate : ReactionViewPod.Delegate {
    fun onTapNewsItem(newsId : Int)
}