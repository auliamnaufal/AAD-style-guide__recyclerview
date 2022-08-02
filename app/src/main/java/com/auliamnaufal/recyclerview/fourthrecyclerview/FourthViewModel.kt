package com.auliamnaufal.recyclerview.fourthrecyclerview

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.auliamnaufal.recyclerview.fourthrecyclerview.retrofit.ApiConfig
import com.auliamnaufal.recyclerview.fourthrecyclerview.retrofit.QuranResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FourthViewModel: ViewModel() {
    val quranChapter = MutableLiveData<QuranResponse>()

    fun quranChapter() {
        ApiConfig.getApiService().quranChapter().enqueue(object : Callback<QuranResponse> {
            override fun onResponse(
                call: Call<QuranResponse>,
                response: Response<QuranResponse>
            ) {
                if (response.isSuccessful) {
                    quranChapter.postValue(response.body())

                }
            }

            override fun onFailure(call: Call<QuranResponse>, t: Throwable) {
                Log.i("Failed",  t.message.toString())
            }

        })
    }

    fun getQuranChapters() : LiveData<QuranResponse> = quranChapter

}