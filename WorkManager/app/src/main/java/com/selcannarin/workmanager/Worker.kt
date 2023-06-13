package com.selcannarin.workmanager

import android.content.Context
import android.util.Log
import androidx.work.WorkerParameters
import androidx.work.Worker

class Worker (appContext: Context, workerParams: WorkerParameters) : Worker(appContext, workerParams){

    override fun doWork() : Result {
        val sum = 10 + 20
        Log.e("Backstack sum: ",sum.toString() )
        return Result.success()
    }
}