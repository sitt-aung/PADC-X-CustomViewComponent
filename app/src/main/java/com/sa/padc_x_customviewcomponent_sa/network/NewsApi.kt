package com.sa.padc_x_customviewcomponent_sa.network

import com.sa.padc_x_customviewcomponent_sa.network.responses.GetAllNewsResponse
import com.sa.padc_x_customviewcomponent_sa.utils.GET_NEWS
import com.sa.padc_x_customviewcomponent_sa.utils.PARAM_ACCESS_TOKEN
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface NewsApi {
    @FormUrlEncoded
    @POST(GET_NEWS)
    fun getAllNews(@Field(PARAM_ACCESS_TOKEN) accessToken : String)
            : Observable<GetAllNewsResponse>
}