package com.sa.padc_x_customviewcomponent_sa.data.models

import android.annotation.SuppressLint
import android.content.Context
import androidx.lifecycle.LiveData
import com.sa.padc_x_customviewcomponent_sa.data.vos.NewsVO
import com.sa.padc_x_customviewcomponent_sa.utils.DUMMY_ACCESS_TOKEN
import com.sa.padc_x_customviewcomponent_sa.utils.EM_NO_INTERNET_CONNECTION
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object NewsModelImpl : NewsModel, BaseModel() {

    override fun getAllNews(onError: (String) -> Unit): LiveData<List<NewsVO>> {
        return mTheDB.newsDao()
            .getAllNews()
    }

    @SuppressLint("CheckResult")
    override fun getAllNewsFromApiAndSaveToDatabase(onSuccess: () -> Unit, onError: (String) -> Unit) {
        mNewsApi
            .getAllNews(DUMMY_ACCESS_TOKEN)
            .map { it.data?.toList() ?: listOf() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                mTheDB.newsDao().insertAllNews(it)
            },{
                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })
    }

    override fun getNewsById(newsId: Int): LiveData<NewsVO> {
        return mTheDB.newsDao().getNewsById(newsId)
    }
}