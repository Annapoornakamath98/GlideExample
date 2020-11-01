package com.yml.glideexample

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RepositoryClass {
    val retro = RetrofitInitializer.getRetrofitInstance()
    val apiInterface = retro.create(APIInterface::class.java)

    fun getRandomImages(randomResponseInterface: RandomResponseInterface){
        val objects = apiInterface.getRandomImages()
        objects.enqueue(object : Callback<ResponseObjects>{
            override fun onResponse(call: Call<ResponseObjects>, response: Response<ResponseObjects>) {
                randomResponseInterface.onResponse(response.body()!!.message)
            }

            override fun onFailure(call: Call<ResponseObjects>, t: Throwable) {
                randomResponseInterface.onFailure(t)
            }

        })
    }

    fun getImages(responseInterface: ResponseInterface) {
        val objects = apiInterface.getImages()
        objects.enqueue(object : Callback<ResponseObjectList>{
            override fun onResponse(call: Call<ResponseObjectList>, response: Response<ResponseObjectList>) {
                responseInterface.onResponse(response.body()!!.message)
            }

            override fun onFailure(call: Call<ResponseObjectList>, t: Throwable) {
                responseInterface.onFailure(t)
            }

        })
    }
}