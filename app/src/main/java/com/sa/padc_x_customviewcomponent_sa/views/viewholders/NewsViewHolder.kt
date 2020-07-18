package com.sa.padc_x_customviewcomponent_sa.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.sa.padc_x_customviewcomponent_sa.data.vos.NewsVO
import com.sa.padc_x_customviewcomponent_sa.delegates.NewsItemDelegate
import com.sa.padc_x_customviewcomponent_sa.views.viewpods.ReactionViewPod
import kotlinx.android.synthetic.main.item_news.view.*

class NewsViewHolder(itemView: View, private val delegate: NewsItemDelegate) :
    BaseNewsViewHolder(itemView) {

    private val mViewPodReaction = itemView.viewPodReaction as ReactionViewPod

    init {
        itemView.setOnClickListener {
            mData?.let {
                delegate.onTapNewsItem(it.id)
            }
        }
    }

    override fun bindData(data: NewsVO) {
        mData = data
        Glide.with(itemView.context)
            .load(data.heroImage)
            .into(itemView.ivNewsImage)
        itemView.tvNewsHeadLine.text = data.title

        mViewPodReaction.bindData(data)
        mViewPodReaction.setDelegate(delegate)
    }




}