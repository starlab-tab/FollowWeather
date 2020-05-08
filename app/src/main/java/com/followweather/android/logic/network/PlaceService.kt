package com.followweather.android.logic.network

import com.followweather.android.FollowWeatherApplication
import com.followweather.android.logic.model.PlaceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PlaceService {

    //http://api.caiyunapp.com/v2/place?query=?&token={f8i8rR2DFrB4M6tO}&lang=zh_CN
    @GET("v2/place?token=${FollowWeatherApplication.TOKEN}&lang=zh_CN")
    fun searchPlace(@Query("query") query: String) : Call<PlaceResponse>
}