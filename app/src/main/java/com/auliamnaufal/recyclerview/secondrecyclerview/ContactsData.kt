package com.auliamnaufal.recyclerview.secondrecyclerview

object ContactsData {
    val nameList = arrayOf("Joko", "Heri", "Udin", "Bambang")
    val avatarList = arrayOf(
        "https://propami.com/assets/corals/images/avatars/avatar_9.png",
        "https://cdn-icons-png.flaticon.com/512/147/147140.png",
        "https://propami.com/assets/corals/images/avatars/avatar_9.png",
        "https://cdn-icons-png.flaticon.com/512/147/147140.png"
    )

    val listContact: ArrayList<Contact>
        get() {
            val tempList = arrayListOf<Contact>()
            for (item in nameList.indices) {
                val list = Contact(
                    name = nameList[item],
                    photoUrl = avatarList[item]
                )
                tempList.add(list)
            }
            return tempList
        }
}