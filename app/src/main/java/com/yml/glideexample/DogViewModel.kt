package com.yml.glideexample

import androidx.lifecycle.ViewModel

class DogViewModel: ViewModel() {
    private val repositoryClass = DogImageRepository()

    fun getRandomImages(randomDogResponseInterface: RandomDogResponseInterface){
        repositoryClass.getRandomImages(object : RandomDogResponseInterface{
            override fun onResponse(data: String) {
                randomDogResponseInterface.onResponse(data)
            }

            override fun onFailure(t: Throwable) {
                randomDogResponseInterface.onFailure(t)
            }

        })
    }

    fun getImages(modelDogListResponseInterface: DogListResponseInterface){
        repositoryClass.getImages(object : DogListResponseInterface{
            override fun onResponse(data: List<String>) {
                modelDogListResponseInterface.onResponse(data)
            }

            override fun onFailure(t: Throwable) {
                modelDogListResponseInterface.onFailure(t)
            }

        })
    }
}