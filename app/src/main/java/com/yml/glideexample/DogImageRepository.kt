package com.yml.glideexample

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DogImageRepository {
    val retro = RetrofitInitializer.getRetrofitInstance()
    val apiInterface = retro.create(APIInterface::class.java)

    fun getRandomImages(randomDogResponseInterface: RandomDogResponseInterface){
        val objects = apiInterface.getRandomImages()
        objects.enqueue(object : Callback<DogResponseObjects>{
            override fun onResponse(call: Call<DogResponseObjects>, dogResponse: Response<DogResponseObjects>) {
                randomDogResponseInterface.onResponse(dogResponse.body()!!.message)
            }

            override fun onFailure(call: Call<DogResponseObjects>, t: Throwable) {
                randomDogResponseInterface.onFailure(t)
            }

        })
    }

    fun getImages(dogListResponseInterface: DogListResponseInterface) {
        val objects = apiInterface.getImages()
        objects.enqueue(object : Callback<DogResponseObjectList>{
            override fun onResponse(call: Call<DogResponseObjectList>, dogResponse: Response<DogResponseObjectList>) {
                dogListResponseInterface.onResponse(dogResponse.body()!!.message)
            }

            override fun onFailure(call: Call<DogResponseObjectList>, t: Throwable) {
                dogListResponseInterface.onFailure(t)
            }

        })
    }
}