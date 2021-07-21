package com.example.studentdetails.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.studentdetails.api.RetrofitProvider
import com.example.studentdetails.models.Detail
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit

class MainViewModel : ViewModel() {
    val  itemLiveData = MutableLiveData<List<Detail>>()
    fun getItem(){
        viewModelScope.launch {
            itemLiveData.postValue(RetrofitProvider.placeHolderAPI.getItem())
        }
    }

    fun postDetails() {
        viewModelScope.launch {
            itemLiveData.postValue(RetrofitProvider.placeHolderAPI.postDetails())
        }
    }
}