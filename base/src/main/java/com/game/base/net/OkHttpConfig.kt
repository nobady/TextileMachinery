package com.game.base.net

import com.game.base.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
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

    private lateinit var okHttpClientBuilder:OkHttpClient.Builder

    fun getOkhttpClient() = getInstance().okHttpClient

    private var okHttpClient:OkHttpClient? = null

    inner class Builder{
        private var defaultConnTime = 30L
        private var headMap = HashMap<String,String>()
        private var isDebug = BuildConfig.DEBUG
        private var logInterceptor:Interceptor = DefaultLogInterceptor()
        private var interceptors = ArrayList<Interceptor>()

        fun build():OkHttpClient{

            okHttpClientBuilder = OkHttpClient.Builder()
            setDebugMode()
            setHeadersConfig()
            setTimeOut()
            seInterceptors()

            okHttpClient = okHttpClientBuilder.build()
            return okHttpClient!!
        }

        fun clearHeadMap(): Builder {
            headMap.clear()
            return this
        }

        fun addHead(key:String,value:String): Builder {
            headMap[key] = value
            return this
        }

        fun setDebugMode(isDebug:Boolean): Builder {
            this.isDebug = isDebug
            return this
        }

        fun setConnTime(time:Long): Builder {
            defaultConnTime = time
            return this
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