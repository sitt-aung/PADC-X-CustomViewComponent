package com.sa.padc_x_customviewcomponent_sa.data.models

import android.content.Context
import com.sa.padc_x_customviewcomponent_sa.network.NewsApi
import com.sa.padc_x_customviewcomponent_sa.persistence.db.NewsDB
import com.sa.padc_x_customviewcomponent_sa.utils.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

abstract class BaseModel {

    protected var mNewsApi: NewsApi
    protected lateinit var mTheDB: NewsDB

    init {
        val mOkHttpClient = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(mOkHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        mNewsApi = retrofit.create(NewsApi::class.java)
    }

    fun initDatabase(context: Context) {
        mTheDB = NewsDB.getDBInstance(context)
    }
}