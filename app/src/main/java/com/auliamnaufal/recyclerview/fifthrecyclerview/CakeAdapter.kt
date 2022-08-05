package com.auliamnaufal.recyclerview.fifthrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.auliamnaufal.recyclerview.databinding.RowItemCakeBinding
import com.auliamnaufal.recyclerview.databinding.RowItemPahlawanBinding
import com.bumptech.glide.Glide

class CakeAdapter(val listCake: ArrayList<BatterItem>):
    RecyclerView.Adapter<CakeAdapter.CakeViewHolder>() {
    inner class CakeViewHolder(val binding : RowItemCakeBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CakeViewHolder(
        RowItemCakeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: CakeViewHolder, position: Int) {
        val data = listCake[position]
        holder.binding.apply {
            tvCakeName.text = data.type
            tvCakeId.text = data.id
        }
    }

    override fun getItemCount() = listCake.size
}