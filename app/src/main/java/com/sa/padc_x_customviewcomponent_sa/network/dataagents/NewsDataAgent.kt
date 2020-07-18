package com.sa.padc_x_customviewcomponent_sa.network.dataagents

import com.sa.padc_x_customviewcomponent_sa.data.vos.NewsVO

interface NewsDataAgent {
    fun getAllNews(
        accessToken : String,
        onSuccess: (List<NewsVO>) -> Unit,
        onFailure: (String) -> Unit)
}