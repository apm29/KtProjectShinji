package com.apm29.projectshinji.model.retro

import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import javax.xml.transform.Result


/**
 * Created by apm29 on 2017/8/15.
 */
 interface ServerInterface{

    companion object {
        fun getBaseURL(urlType:URL_TYPE):String{
            return when(urlType){
                URL_TYPE.MAIN_URL->"http://test.api.zhaosha.com/v3/"
            }
        }
    }
    //http://test.api.zhaosha.com/v3/Home/initHomeViewData?platform=1&version=36&userID=5711
    @GET("Home/initHomeViewData")
    fun initHome(@Query("platform")platform:Int,@Query("version")version:Int,@Query("userID")userID:Int):Call<String>

    interface GithubApiService {

        @GET("search/users")
        fun search(@Query("q") query: String,
                   @Query("page") page: Int,
                   @Query("per_page") perPage: Int): Observable<Result>

        /**
         * Companion object to create the GithubApiService
         */
        companion object Factory {
            fun create(): GithubApiService {
                val retrofit = Retrofit.Builder()
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create())
                        .baseUrl("https://api.github.com/")
                        .build()

                return retrofit.create(GithubApiService::class.java);
            }
        }
    }
    enum class URL_TYPE{
        MAIN_URL
    }
}
