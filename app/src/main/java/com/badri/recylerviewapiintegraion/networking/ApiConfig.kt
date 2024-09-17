package com.badri.recylerviewapiintegraion.networking

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.badri.recylerviewapiintegraion.Utils.CommonUtils.BASE_URL
import com.badri.recylerviewapiintegraion.model.RecyclerviewData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiConfig {
    fun getData(context: Context, callback: (RecyclerviewData) -> Unit) {
        val retrofit =
            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build()

        val service = retrofit.create(ApiService::class.java)

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val data = service.getData()
                CoroutineScope(Dispatchers.Main).launch {
                    Log.i("RecyclerviewData", "$data")
                    callback(data)
                }
            } catch (e: Exception) {
                CoroutineScope(Dispatchers.Main).launch {
                    Toast.makeText(context, "API CALL FAILED", Toast.LENGTH_SHORT).show()
                }
                Log.e("CantFindService", "$e")
            }
        }
    }
}