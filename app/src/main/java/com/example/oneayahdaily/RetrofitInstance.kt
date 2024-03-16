package com.example.oneayahdaily

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private const val Base = "http://10.200.31.127:3000"

    val api: ApiInterface by lazy {
        Retrofit.Builder()
            .baseUrl(Base)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
    }

}
