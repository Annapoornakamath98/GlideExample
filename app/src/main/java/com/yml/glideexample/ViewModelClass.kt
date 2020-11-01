package com.yml.glideexample

import androidx.lifecycle.ViewModel

class ViewModelClass: ViewModel() {
    private val repositoryClass = RepositoryClass()

    fun getRandomImages(randomResponseInterface: RandomResponseInterface){
        repositoryClass.getRandomImages(object : RandomResponseInterface{
            override fun onResponse(data: String) {
                randomResponseInterface.onResponse(data)
            }

            override fun onFailure(t: Throwable) {
                randomResponseInterface.onFailure(t)
            }

        })
    }

    fun getImages(modelResponseInterface: ResponseInterface){
        repositoryClass.getImages(object : ResponseInterface{
            override fun onResponse(data: List<String>) {
                modelResponseInterface.onResponse(data)
            }

            override fun onFailure(t: Throwable) {
                modelResponseInterface.onFailure(t)
            }

        })
    }
}