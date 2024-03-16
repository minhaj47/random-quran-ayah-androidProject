package com.example.oneayahdaily

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    val myResponse : MutableLiveData<Ayah> = MutableLiveData()

//    fun getAyah(){
//        viewModelScope.launch {
//            val response: Ayah = repository.getAyah()
//            myResponse.value = response
//        }
//    }

}