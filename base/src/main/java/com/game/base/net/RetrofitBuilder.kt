package com.game.base.net

import android.text.format.Time
import com.game.base.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Administrator on 2019/1/5.
 */
class RetrofitBuilder private constructor(builder: Builder){

    private lateinit var rtRetrofit:Retrofit

    init {
        build(builder)
    }

    fun create(serviceApi:Class<Any>) = rtRetrofit.create(serviceApi)

    private fun build(builder: Builder){
        rtRetrofit = Retrofit.Builder()
            .baseUrl(builder.baseUrl)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(initOkhttp(builder))
            .build()
    }

    private fun initOkhttp(builder: Builder): OkHttpClient {
        val okClient = OkHttpClient.Builder()
            .connectTimeout(builder.connTime,TimeUnit.SECONDS)
            .readTimeout(builder.connTime,TimeUnit.SECONDS)
            .writeTimeout(builder.connTime,TimeUnit.SECONDS)

        if (BuildConfig.DEBUG){
            okClient.addInterceptor(builder.logInterceptor)
        }
        builder.networkInterceptor?.let { okClient.addNetworkInterceptor(it) }

        return okClient.build()
    }


    class Builder{
        lateinit var baseUrl:String
        var connTime = 10L
        var logInterceptor = DefaultLogInterceptor()
        var networkInterceptor:Interceptor? = null

        fun build() = RetrofitBuilder(this)
    }


}