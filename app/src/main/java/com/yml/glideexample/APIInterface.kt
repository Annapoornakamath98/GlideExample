package com.yml.glideexample

import retrofit2.Call
import retrofit2.http.GET

interface APIInterface {
    @GET("random")
    fun getRandomImages(): Call<ResponseObjects>

    @GET("random/30")
    fun getImages(): Call<ResponseObjectList>
}