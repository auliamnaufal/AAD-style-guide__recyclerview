package com.auliamnaufal.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.auliamnaufal.recyclerview.databinding.ActivityMainBinding
import com.auliamnaufal.recyclerview.fifthrecyclerview.FifthActivity
import com.auliamnaufal.recyclerview.firstrecyclerview.FirstActivity
import com.auliamnaufal.recyclerview.fourthrecyclerview.FourthActivity
import com.auliamnaufal.recyclerview.secondrecyclerview.SecondActivity
import com.auliamnaufal.recyclerview.thirdrecyclerview.ThirdActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnFirstRecyclerView.setOnClickListener {
            startActivity(Intent(this, FirstActivity::class.java))
        }

        binding.btnSecondRecyclerView.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }

        binding.btnThirdRecyclerView.setOnClickListener {
            startActivity(Intent(this, ThirdActivity::class.java))
        }

        binding.btnFourthRecyclerView.setOnClickListener {
            startActivity(Intent(this, FourthActivity::class.java))
        }

        binding.btnFifthRecyclerView.setOnClickListener {
            startActivity(Intent(this, FifthActivity::class.java))
        }
    }
}