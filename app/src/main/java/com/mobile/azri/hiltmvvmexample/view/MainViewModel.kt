package com.mobile.azri.hiltmvvmexample.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mobile.azri.hiltmvvmexample.model.RecyclerData
import com.mobile.azri.hiltmvvmexample.network.RetroRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: RetroRepository
) : ViewModel() {

    var liveDataList : MutableLiveData<List<RecyclerData>> = MutableLiveData()

    fun getLiveDataObserver(): MutableLiveData<List<RecyclerData>>{
        return liveDataList
    }

    fun loadListOfData(){
        repository.makeApiCall("ny",liveDataList)
    }
}