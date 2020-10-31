package com.yml.glideexample

import retrofit2.Call
import retrofit2.http.GET

interface APIInterface {
    @GET("/api/breeds/image/random")
    fun getImage(): Call<List<ResponseObjects>>

    @GET("/api/breeds/image/random/30")
    fun getImages(): Call<List<ResponseObjects>>
}