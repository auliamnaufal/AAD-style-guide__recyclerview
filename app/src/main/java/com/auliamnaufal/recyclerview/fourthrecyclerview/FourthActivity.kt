package com.auliamnaufal.recyclerview.fourthrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.auliamnaufal.recyclerview.databinding.ActivityFourthBinding
import com.auliamnaufal.recyclerview.fourthrecyclerview.retrofit.ApiConfig
import com.auliamnaufal.recyclerview.fourthrecyclerview.retrofit.ChaptersItem
import com.auliamnaufal.recyclerview.fourthrecyclerview.retrofit.QuranResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FourthActivity : AppCompatActivity() {
    lateinit var binding: ActivityFourthBinding
    lateinit var viewModel: FourthViewModel

    private val mAdapter by lazy {ChapterAdapter()}


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFourthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[FourthViewModel::class.java]

        viewModel.quranChapter()

        viewModel.getQuranChapters().observe(this) {
            mAdapter.setData(it.chapters as List<ChaptersItem>)
            binding.rvChapter.apply {
                adapter = mAdapter
                layoutManager = LinearLayoutManager(this@FourthActivity)
            }
        }

    }
}