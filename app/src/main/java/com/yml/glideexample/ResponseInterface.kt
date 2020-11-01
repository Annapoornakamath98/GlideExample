package com.yml.glideexample

interface ResponseInterface {
    fun onResponse(data: List<String>)
    fun onFailure(t: Throwable)
}