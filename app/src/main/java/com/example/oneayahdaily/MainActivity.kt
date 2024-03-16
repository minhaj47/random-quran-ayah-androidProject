package com.example.oneayahdaily

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : ComponentActivity() {

    private var ayahs by mutableStateOf<List<Ayah>>(emptyList())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                println("alfdjf")

                for (ayah in ayahs){
                    AppUi(ayah = ayah)
                }
            }
        }
        getData()

    }

    private fun getData() {
        val getAllAyah: Call<List<Ayah>> = RetrofitInstance.api.getRandomAyah()

        getAllAyah.enqueue(object : Callback<List<Ayah>?> {
            override fun onResponse(call: Call<List<Ayah>?>, response: Response<List<Ayah>?>) {
                if(response.isSuccessful){
                    response.body()?.let {
                        for (ayah in it){
                            Log.i("rtro", "onResponse: Successful -- ${ayah.translation}")
                        }
                        ayahs = response.body()!!
                    }
                }
            }

            override fun onFailure(call: Call<List<Ayah>?>, t: Throwable) {
                Log.i("rettro", "ON Failure: ${t.message}")
            }
        })
    }
}

@Composable
fun AppUi(
    modifier: Modifier = Modifier,
    ayah: Ayah
) {

    Column(
        modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Today's Ayah: ",
            fontSize = 18.sp,
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = ayah.arabicText,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = ayah.translation,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = "(Surah No: ${ayah.surah},Verse: ${ayah.verse})",
            fontSize = 13.sp
        )
    }

}
