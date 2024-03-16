package com.example.oneayahdaily

import com.google.gson.annotations.SerializedName
import retrofit2.Response

data class Ayah(
    val surah: Number,
    val verse: Number,
    @SerializedName("arabic_text")
    val arabicText: String,
    val translation: String,
)
