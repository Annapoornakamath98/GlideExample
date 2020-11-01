package com.yml.glideexample

import androidx.lifecycle.ViewModel

class ViewModelClass: ViewModel() {
    private val repositoryClass = RepositoryClass()
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