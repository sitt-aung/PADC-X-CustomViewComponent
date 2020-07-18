package com.sa.padc_x_customviewcomponent_sa.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.sa.padc_x_customviewcomponent_sa.R
import com.sa.padc_x_customviewcomponent_sa.adapters.NewsListAdapter
import com.sa.padc_x_customviewcomponent_sa.data.vos.NewsVO
import com.sa.padc_x_customviewcomponent_sa.mvp.presenters.MainPresenter
import com.sa.padc_x_customviewcomponent_sa.mvp.presenters.MainPresenterImpl
import com.sa.padc_x_customviewcomponent_sa.mvp.views.MainView
import com.sa.padc_x_customviewcomponent_sa.utils.EMPTY_IMAGE_URL
import com.sa.padc_x_customviewcomponent_sa.utils.EM_NO_NEWS_AVAILABLE
import com.sa.padc_x_customviewcomponent_sa.views.viewpods.EmptyViewPod
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), MainView {

    private lateinit var mAdapter: NewsListAdapter

    private lateinit var viewPodEmpty: EmptyViewPod

    private lateinit var mPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpPresenter()

        hideEmptyView()
        setUpSwipeRefresh()
        setUpRecyclerView()
//        setUpViewPod()
        mPresenter.onUiReady(this)
    }

    override fun displayNewsList(newsList: List<NewsVO>) {
        mAdapter.setNewData(newsList.toMutableList())
    }

    override fun navigateToNewsDetails(newsId: Int) {
        startActivity(NewsDetailActivity.newItent(this, newsId))
    }

    override fun displayEmptyView() {
        showEmptyView()
    }

    override fun enableSwipeRefresh() {
        swipeRefreshLayout.isRefreshing = true
    }

    override fun disableSwipeRefresh() {
        swipeRefreshLayout.isRefreshing = false
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(MainPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setUpViewPod() {
        viewPodEmpty = vpEmpty as EmptyViewPod
        viewPodEmpty.setEmptyData(EM_NO_NEWS_AVAILABLE, EMPTY_IMAGE_URL)
    }

    private fun setUpSwipeRefresh() {
        swipeRefreshLayout.setOnRefreshListener {
            mPresenter.onSwipeRefresh(this)
        }
    }

    private fun setUpRecyclerView() {
        mAdapter = NewsListAdapter(mPresenter)
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvNews.layoutManager = linearLayoutManager
        rvNews.adapter = mAdapter
    }

    private fun showEmptyView() {
        vpEmpty.visibility = View.VISIBLE
    }

    private fun hideEmptyView() {
        vpEmpty.visibility = View.GONE
    }

}