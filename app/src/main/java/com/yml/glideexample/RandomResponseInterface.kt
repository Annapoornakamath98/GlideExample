package com.yml.glideexample

interface RandomResponseInterface {
    fun onResponse(data:String)
    fun onFailure(t : Throwable)
}