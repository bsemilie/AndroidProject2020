package com.ismin.projectapp

import java.io.Serializable

data class Candy(
    val bar: Int,
    val caramel: Int,
    val chocolate: Int,
    val competitorname: String,
    val crispedricewafer: Int,
    val fruity: Int,
    val hard: Int,
    val nougat: Int,
    val peanutyalmondy: Int,
    val pluribus: Int,
    val pricepercent: Double,
    val sugarpercent: Double,
    val winpercent: Double,
    val image: String
) : Serializable
