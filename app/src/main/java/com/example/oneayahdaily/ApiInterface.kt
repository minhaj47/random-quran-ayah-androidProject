package com.example.oneayahdaily

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("api/products")
    fun getRandomAyah(): Call<List<Ayah>>

}

