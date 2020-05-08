package com.followweather.android.ui.place

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.followweather.android.Repository
import com.followweather.android.logic.model.Place

class PlaceViewModel() : ViewModel() {

    val placeList = ArrayList<Place>()

    //存放搜索框的值,并observer
    private val searchLiveData = MutableLiveData<String>()

    val placeLiveData = Transformations.switchMap(searchLiveData) {
        Repository.searchPlace(query = it)
    }

    fun searchPlace(query: String) {
        searchLiveData.value = query
    }
}