package com.followweather.android.logic.network

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.RuntimeException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

object FollowWeatherNetwork {

    private val placeService = ServiceCreator.create<PlaceService>()

//    private val placeService = ServiceCreator.create(PlaceService::class.java)

    suspend fun searchPlaces(query: String) = placeService.searchPlace(query).await()

    private suspend fun <T> Call<T>.await() : T {
        return suspendCoroutine {
            enqueue(object : Callback<T> {
                override fun onResponse(call: Call<T>, response: Response<T>) {
                    val body = response.body()
                    if (body != null) it.resume(body)
                    else it.resumeWithException(RuntimeException("Response body is empty"))
                }

                override fun onFailure(call: Call<T>, t: Throwable) {
                    it.resumeWithException(t)
                }
            })
        }
    }
}