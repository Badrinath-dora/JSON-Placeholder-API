package com.badri.recylerviewapiintegraion.networking

import com.badri.recylerviewapiintegraion.model.RecyclerviewData
import retrofit2.http.GET


interface ApiService {
    @GET("posts")
    suspend fun getData(): RecyclerviewData
}