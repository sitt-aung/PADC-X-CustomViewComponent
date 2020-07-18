package com.sa.padc_x_customviewcomponent_sa.workers

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.sa.padc_x_customviewcomponent_sa.data.models.NewsModel
import com.sa.padc_x_customviewcomponent_sa.data.models.NewsModelImpl

abstract class BaseWorker(context: Context, workerParams: WorkerParameters)
    : Worker(context, workerParams) {

    val mNewsModel : NewsModel = NewsModelImpl
}