package com.auliamnaufal.recyclerview.secondrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.auliamnaufal.recyclerview.R
import com.auliamnaufal.recyclerview.databinding.ActivitySecondBinding
import com.auliamnaufal.recyclerview.databinding.RowContactItemBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvContact.apply {
            adapter = ContactAdapter(ContactsData.listContact)
            Log.i("SecondActivity", "onCreate: ${ContactsData.listContact}")
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
    }
}