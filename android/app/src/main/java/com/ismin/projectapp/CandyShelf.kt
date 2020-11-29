package com.ismin.projectapp

import java.io.Serializable

class CandyShelf : Serializable {
    private val storage = HashMap<String, Candy>()

    fun addCandy(candy: Candy) {
        this.storage[candy.competitorname] = candy
    }

    fun getCandy(competitorname: String): Candy? {
        return this.storage[competitorname]
    }

    fun getAllCandies(): ArrayList<Candy> {
        return  ArrayList(this.storage.values.sortedBy { candy -> candy.competitorname })
    }

    fun getTotalNumberOfCandies(): Int {
        return this.storage.size
    }

}