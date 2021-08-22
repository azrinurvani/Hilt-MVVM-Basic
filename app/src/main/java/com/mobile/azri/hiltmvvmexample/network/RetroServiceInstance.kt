package com.mobile.azri.hiltmvvmexample.network

import com.mobile.azri.hiltmvvmexample.model.RecyclerList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroServiceInstance {

    @GET("repositories")
    fun getDataFromApi(
        @Query("q") query: String
    ) : Call<RecyclerList>
}