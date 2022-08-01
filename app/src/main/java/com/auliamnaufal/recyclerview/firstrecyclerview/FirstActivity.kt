package com.auliamnaufal.recyclerview.firstrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.auliamnaufal.recyclerview.R
import com.auliamnaufal.recyclerview.databinding.ActivityFirstBinding

class FirstActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFirstBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val animalList = AnimalModel(this).getAnimalList()
        binding.rvAnimal.adapter = AnimalAdapter(animalList)

    }
}