package com.auliamnaufal.recyclerview.fifthrecyclerview

data class ModelCake(
    var id: String,
    var type: String,
    val batters: Batter
)

data class Batter(
    val Batter: ArrayList<BatterItem>
)

class BatterItem(
    var id: String,
    var type: String
)

