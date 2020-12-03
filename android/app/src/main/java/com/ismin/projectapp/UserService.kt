package com.ismin.projectapp

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface UserService {
    @GET("users/{userId}/favorites")
    fun getUserFavorites(@Path("userId") userId: String): Call<ArrayList<String>>

    @POST("users/{userId}/favorites")
    fun addUserFavorites(@Path("userId") userId:String, @Body() candyName: CandyName): Call<ArrayList<String>>

    @DELETE("users/{userId}/favorites/{candyName}")
    fun deleteUserFavorite(@Path("userId")userId: String, @Path("candyName") candyBarName: String): Call<ArrayList<String>>

}