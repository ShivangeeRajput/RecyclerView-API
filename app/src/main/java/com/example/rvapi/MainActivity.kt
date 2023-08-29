package com.example.rvapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val serviceGenerator=ServiceGenerator.buildService(APIService::class.java)
        val call=serviceGenerator.getPosts()

        call.enqueue(object : Callback<MutableList<PostModel>>,
            retrofit2.Callback<MutableList<PostModel>> {
            override fun onResponse(
                call: Call<MutableList<PostModel>>,
                response: Response<MutableList<PostModel>>
            ) {
            if (response.isSuccessful){
                Log.e("Success",response.body().toString())
            }
            }

            override fun onFailure(call: Call<MutableList<PostModel>>, t: Throwable) {
            t.printStackTrace()
                Log.e("Error",t.message.toString())
            }

        })
    }
}