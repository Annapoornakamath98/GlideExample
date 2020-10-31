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
//            Glide.with(this@MainActivity)
//                        .load("https://dog.ceo/api/breeds/image/random")
//                        .into(imageView)

        }
        btnDisplay.setOnClickListener {
            startActivity(Intent(applicationContext,DisplayActivity::class.java))
        }
    }
    fun loadImages(){
        val retro = RetrofitInitializer.getRetrofitInstance()
        val apiInterface = retro.create(APIInterface::class.java)
        val objects : Call<List<ResponseObjects>> = apiInterface.getImage()
        objects.enqueue(object : Callback<List<ResponseObjects>>{
            override fun onResponse(
                    call: Call<List<ResponseObjects>>,
                    response: Response<List<ResponseObjects>>
            ) {
                val uList: List<ResponseObjects>? = response.body()
                Toast.makeText(this@MainActivity,uList.toString(),Toast.LENGTH_LONG).show()
            }
            override fun onFailure(call: Call<List<ResponseObjects>>, t: Throwable) {
                Toast.makeText(this@MainActivity,t.toString(),Toast.LENGTH_LONG).show()
            }

        })
    }
}