package com.auliamnaufal.recyclerview.secondrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.auliamnaufal.recyclerview.databinding.RowAnimalItemBinding
import com.auliamnaufal.recyclerview.databinding.RowContactItemBinding
import com.bumptech.glide.Glide

class ContactAdapter(private val contactList: ArrayList<Contact>) : RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {
    class ContactViewHolder(val binding: RowContactItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ContactViewHolder(
        RowContactItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.binding.apply {
            tvContactName.text = contactList[position].name

            Glide.with(imgAvatar.context)
                .load(contactList[position].photoUrl)
                .override(500, 500)
                .into(imgAvatar)
        }
    }

    override fun getItemCount() = contactList.size
}