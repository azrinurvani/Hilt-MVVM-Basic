package com.mobile.azri.hiltmvvmexample.network

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.mobile.azri.hiltmvvmexample.model.RecyclerData
import com.mobile.azri.hiltmvvmexample.model.RecyclerList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class RetroRepository @Inject constructor(private val retroServiceInstance: RetroServiceInstance) {

    fun makeApiCall(query:String,liveDataList: MutableLiveData<List<RecyclerData>>){
        val call = retroServiceInstance.getDataFromApi(query)

        call.enqueue(object: Callback<RecyclerList>{
            override fun onResponse(call: Call<RecyclerList>, response: Response<RecyclerList>) {

                if (response.isSuccessful){
                    liveDataList.postValue(response.body()?.items)
                }else{
                    liveDataList.postValue(null)
                }


            }

            override fun onFailure(call: Call<RecyclerList>, t: Throwable) {
                liveDataList.postValue(null)
                Log.e(TAG, "makeApiCall.onFailure: ${t.localizedMessage}")
            }

        })
    }

    companion object {
        private const val TAG = "RetroRepository"
    }
}