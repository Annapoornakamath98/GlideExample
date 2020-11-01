package com.yml.glideexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_display.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DisplayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val viewModel = ViewModelClass()
        viewModel.getImages(object : ResponseInterface{
            override fun onResponse(data: List<String>) {
                recyclerView.adapter = AdapterClass(this@DisplayActivity,data)
            }

            override fun onFailure(t: Throwable) {
                Toast.makeText(this@DisplayActivity,t.toString(),Toast.LENGTH_LONG).show()
            }

        })

    }
}