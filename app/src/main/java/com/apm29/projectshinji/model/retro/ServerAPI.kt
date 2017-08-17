package com.apm29.projectshinji.model.retro

import android.util.Log
import com.apm29.projectshinji.model.bean.HomeBean
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory


/**
 * Created by apm29 on 2017/8/15.
 */

object ServerAPI {
    fun initHome(init: (HomeBean?) -> Unit, platform: Int, version: Int, userID: Int){
        val retrofit = Retrofit.Builder()
                .baseUrl(ServerInterface.getBaseURL(ServerInterface.URL_TYPE.MAIN_URL))
                .addConverterFactory(ScalarsConverterFactory.create())
                .build()
        val create = retrofit.create(ServerInterface::class.java)
        val realCall = create.initHome(platform, version, userID)
        realCall.enqueue(
                object : Callback<String> {
                    override fun onFailure(call: Call<String>?, t: Throwable?) {
                        Log.d("fail","fail")
                    }

                    override fun onResponse(call: Call<String>?, response: Response<String>?) {
                        Log.d("onResponse","onResponse:"+response!!.body().toString())
                    }

                }
        )
    }
}