package com.auliamnaufal.recyclerview.fourthrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.auliamnaufal.recyclerview.databinding.RowContactItemBinding
import com.auliamnaufal.recyclerview.databinding.RowItemChapterBinding
import com.auliamnaufal.recyclerview.fourthrecyclerview.retrofit.ChaptersItem
import com.auliamnaufal.recyclerview.secondrecyclerview.Contact
import com.auliamnaufal.recyclerview.secondrecyclerview.ContactAdapter
import com.bumptech.glide.Glide

class ChapterAdapter : RecyclerView.Adapter<ChapterAdapter.ChapterViewHolder>() {
    private val listChapter = ArrayList<ChaptersItem>()

    class ChapterViewHolder(val binding: RowItemChapterBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ChapterViewHolder(
        RowItemChapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ChapterViewHolder, position: Int) {
        val data = listChapter[position]
        holder.binding.apply {
            surahName.text = data.nameSimple.toString()
            surahNo.text = data.id.toString()
            surahTipe.text = data.revelationPlace.toString()
            surahVerses.text = data.versesCount.toString()
        }
    }

    override fun getItemCount() = listChapter.size

    fun setData(data: List<ChaptersItem>) {
        if (data == null) return
        listChapter.clear()
        listChapter.addAll(data)
    }
}