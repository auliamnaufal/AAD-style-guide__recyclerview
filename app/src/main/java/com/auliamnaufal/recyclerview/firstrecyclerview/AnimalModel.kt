package com.auliamnaufal.recyclerview.firstrecyclerview

import android.content.Context
import com.auliamnaufal.recyclerview.R

class AnimalModel(val context: Context) {
    fun getAnimalList(): Array<String> {
        return context.resources.getStringArray(R.array.animal_list)
    }
}