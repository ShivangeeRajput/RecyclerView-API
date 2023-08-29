package com.example.rvapi

import retrofit2.Call
import retrofit2.http.GET

interface APIService {
    @GET("/posts")
    fun getPosts(): Call<MutableList<PostModel>>

}