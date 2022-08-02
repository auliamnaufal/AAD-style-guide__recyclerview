package com.auliamnaufal.recyclerview.fourthrecyclerview.retrofit

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("chapters")
    fun quranChapter() : Call<QuranResponse>
}