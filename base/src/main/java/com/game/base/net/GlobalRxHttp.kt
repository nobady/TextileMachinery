package com.game.base.net

import okhttp3.Call
import okhttp3.OkHttpClient
import retrofit2.CallAdapter
import retrofit2.Converter

/**
 * Created by lff on 2019/1/11.
 */
class GlobalRxHttp private constructor(){

    companion object {
        fun getIntance() = SingletonHolder.holder
    }

    private object SingletonHolder{
        val holder = GlobalRxHttp()
    }

    fun getGlobalRetrofit() = RetrofitClient.getInstance().getRetrofit()

    fun getGlobalRetrofitBuilder() = RetrofitClient.getInstance().getRetrofitBuilder()

    fun setBaseUrl(baseUrl:String): GlobalRxHttp {
        getGlobalRetrofitBuilder().baseUrl(baseUrl)
        return this
    }

    fun setClient(client: OkHttpClient): GlobalRxHttp {
        getGlobalRetrofitBuilder().client(client)
        return this
    }

    fun addConverterFactors(factory:Converter.Factory): GlobalRxHttp {
        RetorfitConfig.getInstance().addConvertFactor(factory)
        return this
    }

    fun addCallAdapterFactors(factory:CallAdapter.Factory): GlobalRxHttp {
        RetorfitConfig.getInstance().addCallAdapter(factory)
        return this
    }

    fun <K> createService(cls:Class<K>):K?{
        return getGlobalRetrofit()?.create(cls)
    }
}