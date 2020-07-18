package com.sa.padc_x_customviewcomponent_sa.data.models

import androidx.lifecycle.LiveData
import com.sa.padc_x_customviewcomponent_sa.data.vos.NewsVO

interface NewsModel {
    fun getAllNews(onError: (String) -> Unit) : LiveData<List<NewsVO>>
    fun getAllNewsFromApiAndSaveToDatabase(onSuccess: () -> Unit, onError: (String) -> Unit)
    fun getNewsById(newsId: Int) : LiveData<NewsVO>
}