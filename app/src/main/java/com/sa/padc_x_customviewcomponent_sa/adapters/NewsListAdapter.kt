package com.sa.padc_x_customviewcomponent_sa.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.sa.padc_x_customviewcomponent_sa.R
import com.sa.padc_x_customviewcomponent_sa.data.vos.NewsVO
import com.sa.padc_x_customviewcomponent_sa.delegates.NewsItemDelegate
import com.sa.padc_x_customviewcomponent_sa.views.viewholders.BaseNewsViewHolder
import com.sa.padc_x_customviewcomponent_sa.views.viewholders.NewsSmallViewHolder
import com.sa.padc_x_customviewcomponent_sa.views.viewholders.NewsViewHolder

class NewsListAdapter(delegate: NewsItemDelegate)
    : BaseRecyclerAdapter<BaseNewsViewHolder, NewsVO>() {

    val mDelegate: NewsItemDelegate = delegate
    val VIEW_TYPE_LARGE = 2244
    val VIEW_TYPE_SMALL = 1122

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseNewsViewHolder {

        when (viewType) {
            VIEW_TYPE_LARGE -> {
                val view =
                    LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
                return NewsViewHolder(view, mDelegate)
            }
            VIEW_TYPE_SMALL -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_news_small, parent, false)
                return NewsSmallViewHolder(view, mDelegate)
            }
            else -> {
                val view =
                    LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
                return NewsViewHolder(view, mDelegate)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        when {
            position % 3 == 0 -> {
                return VIEW_TYPE_LARGE
            }
            else -> {
                return VIEW_TYPE_SMALL
            }
        }
    }
}