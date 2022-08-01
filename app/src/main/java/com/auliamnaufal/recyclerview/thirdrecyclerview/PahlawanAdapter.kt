package com.auliamnaufal.recyclerview.thirdrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.auliamnaufal.recyclerview.databinding.RowItemPahlawanBinding
import com.bumptech.glide.Glide

class PahlawanAdapter(val listPahlawan: MutableList<ModelPahlawan>):
    RecyclerView.Adapter<PahlawanAdapter.PahlawanViewHolder>() {
    inner class PahlawanViewHolder(val binding : RowItemPahlawanBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PahlawanViewHolder(
        RowItemPahlawanBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: PahlawanViewHolder, position: Int) {
        holder.binding.apply {
            with(listPahlawan[position]) {
                tvNamaPahlawan.text = this.nama
                tvNamaLengkap.text = this.namaLengkap

                Glide.with(imagePahlawan.context)
                    .load(this.image)
                    .into(imagePahlawan)
            }
        }
    }

    override fun getItemCount() = listPahlawan.size
}