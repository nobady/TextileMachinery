package com.game.base.net

import com.game.base.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

/**
 * Created by lff on 2019/1/11.
 */
class OkHttpConfig private constructor(){

    companion object {
        fun getInstance() = SingletonHolder.holder
    }
    private object SingletonHolder{
        val holder = OkHttpConfig()
    }

    private val okHttpClientBuilder = OkHttpClient.Builder()

    fun getOkhttpClient() = getInstance().okHttpClient

    private var okHttpClient:OkHttpClient? = null

    inner class Builder{
        var defaultConnTime = 30L
        var headMap = HashMap<String,String>()
        var isDebug = BuildConfig.DEBUG
        var logInterceptor:Interceptor = DefaultLogInterceptor()
        var interceptors = ArrayList<Interceptor>()

        fun build():OkHttpClient{

            setDebugMode()
            setHeadersConfig()
            setTimeOut()
            seInterceptors()

            okHttpClient = okHttpClientBuilder.build()
            return okHttpClient!!
        }

        private fun setDebugMode(){
            if (isDebug) {
                okHttpClientBuilder.addInterceptor(logInterceptor)
            }
        }

        private fun setHeadersConfig(){
            if (headMap.size>0) {
                okHttpClientBuilder.addInterceptor{
                        chain ->
                    val origReq = chain.request()
                    val newBuilder = origReq.newBuilder()
                    headMap.keys.forEach {
                        newBuilder.addHeader(it,headMap[it])
                    }
                    val newReq = newBuilder.build()
                    chain.proceed(newReq)
                }
            }
        }

        private fun seInterceptors(){
            interceptors.forEach { okHttpClientBuilder.addInterceptor(it) }
        }

        private fun setTimeOut(){
            okHttpClientBuilder.connectTimeout(defaultConnTime,TimeUnit.SECONDS)
            okHttpClientBuilder.writeTimeout(defaultConnTime,TimeUnit.SECONDS)
            okHttpClientBuilder.readTimeout(defaultConnTime,TimeUnit.SECONDS)
            okHttpClientBuilder.retryOnConnectionFailure(true)
        }

    }


}