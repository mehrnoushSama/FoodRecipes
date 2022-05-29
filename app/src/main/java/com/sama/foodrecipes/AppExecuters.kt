package com.sama.foodrecipes

import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService

class AppExecuters {

    private final val mNetworkIO: ScheduledExecutorService = Executors.newScheduledThreadPool(3)

    companion object {
        private lateinit var instance: AppExecuters
        fun getInstance(): AppExecuters {
            if (instance == null)
                instance = AppExecuters()
            return instance
        }

    }

    fun networkIO(): ScheduledExecutorService {
        return mNetworkIO
    }


}