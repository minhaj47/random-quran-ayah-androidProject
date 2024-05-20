package com.example.oneayahdaily

import android.app.Application

class MyApp: Application() {
    companion object{
        lateinit var ayahs: List<Ayah>
    }
}