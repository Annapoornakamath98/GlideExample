package com.yml.glideexample

interface RandomDogResponseInterface {
    fun onResponse(data:String)
    fun onFailure(t : Throwable)
}