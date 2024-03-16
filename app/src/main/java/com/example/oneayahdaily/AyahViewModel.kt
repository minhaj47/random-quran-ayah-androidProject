package com.example.oneayahdaily.viewmodel
//
//import androidx.lifecycle.ViewModel
//import com.example.oneayahdaily.MainActivity
//import com.example.oneayahdaily.Ayah
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response
//
//class AyahViewModel : ViewModel() {
//
//    fun fetchAyah() {
//
//
//        getAllAyah.enqueue(
//            object : Callback<List<Ayah>> {
//                override fun onResponse(
//                    call: Call<List<Ayah>>,
//                    response: Response<List<Ayah>>
//                ) {
//                    if (response.isSuccessful) {
//                        // Handle successful response
//                        val resultList: List<Ayah>? = response.body()
//                        if (resultList != null && resultList.isNotEmpty()) {
//                            MainActivity.ayah = resultList.first()
//                        } else {
//                            // Handle the case where the response body is empty or null
//                            println("response body empty.")
//                        }
//                    } else {
//                        // Handle API call failure
//                        println("api call failure")
//                    }
//                }
//
//                override fun onFailure(
//                    call: Call<List<Ayah>>,
//                    t: Throwable
//                ) {
//                    // Handle network failure
////                    Toast
////                        .makeText(
////                            context,
////                            "Network failure. Error: ${t.message}",
////                            Toast.LENGTH_SHORT
////                        )
////                        .show()
//                    println("network failure")
//                }
//            }
//        )
//    }
//}
