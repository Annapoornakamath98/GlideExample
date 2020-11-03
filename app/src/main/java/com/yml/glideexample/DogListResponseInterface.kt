package com.yml.glideexample

interface DogListResponseInterface {
    fun onResponse(data: List<String>)
    fun onFailure(t: Throwable)
}