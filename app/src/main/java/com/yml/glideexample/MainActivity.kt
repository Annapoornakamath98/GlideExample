package com.yml.glideexample

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        fab.setOnClickListener {
                loadImages()
        }
        btnDisplay.setOnClickListener {
            startActivity(Intent(applicationContext,DisplayActivity::class.java))
        }
    }
    private fun loadImages(){
        val viewModel = ViewModelClass()
        viewModel.getRandomImages(object : RandomResponseInterface{
            override fun onResponse(data: String) {
                Glide.with(this@MainActivity)
                        .load(data)
                        .into(imageView)
            }

            override fun onFailure(t: Throwable) {
                Toast.makeText(this@MainActivity,t.toString(),Toast.LENGTH_LONG).show()
            }

        })
    }
}