package com.auliamnaufal.recyclerview.fourthrecyclerview.retrofit

import com.google.gson.annotations.SerializedName

data class QuranResponse(

	@field:SerializedName("chapters")
	val chapters: List<ChaptersItem?>? = null
)

data class ChaptersItem(

	@field:SerializedName("verses_count")
	val versesCount: Int? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("name_simple")
	val nameSimple: String? = null,

	@field:SerializedName("revelation_place")
	val revelationPlace: String? = null
)
