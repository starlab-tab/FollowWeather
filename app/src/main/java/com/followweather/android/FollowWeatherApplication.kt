package com.followweather.android

import android.app.Application
import android.content.Context

class FollowWeatherApplication : Application(){

    companion object {

        const val TOKEN = "BNBRvBveaD2VfHVI" // 填入你申请到的令牌值

        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}