package com.ismin.projectapp

import retrofit2.Call
import retrofit2.http.*

interface CandyService {
    @GET("candyBars")
    fun getCandyBars(): Call<ArrayList<Candy>>

    @POST("candyBars")
    fun createCandyBar(@Body() candyBar: Candy): Call<Candy>

    @GET("candyBars/{competitorname}")
    fun getCandyBar(@Path("competitorname") competitorname: String): Call<Candy>

    @DELETE("candyBars/{competitorname}")
    fun deleteCandyBar(@Path("competitorname") competitorname: String)
}