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
        val retro = RetrofitInitializer.getRetrofitInstance()
        val apiInterface = retro.create(APIInterface::class.java)
        val objects : Call<ResponseObjects> = apiInterface.getRandomImages()
        objects.enqueue(object : Callback<ResponseObjects>{
            override fun onResponse(
                    call: Call<ResponseObjects>,
                    response: Response<ResponseObjects>
            ) {
                val data = response.body()!!.message
                Glide.with(this@MainActivity)
                        .load(data)
                        .into(imageView)
            }
            override fun onFailure(call: Call<ResponseObjects>, t: Throwable) {
                Toast.makeText(this@MainActivity,t.toString(),Toast.LENGTH_LONG).show()
            }


        })
    }
}