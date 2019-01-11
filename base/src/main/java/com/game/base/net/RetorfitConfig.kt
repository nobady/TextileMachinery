package com.game.base.net

import retrofit2.CallAdapter
import retrofit2.Converter

/**
 * Created by lff on 2019/1/11.
 */
class RetorfitConfig private constructor(){

    companion object {
        fun getInstance() = SingletonHolder.holder
    }

    private object SingletonHolder{
        val holder = RetorfitConfig()
    }

    private val callAdapterFactor by lazy {  ArrayList<CallAdapter.Factory>() }
    private val convertFactors by lazy {  ArrayList<Converter.Factory>() }

    fun addCallAdapter(callFactor:CallAdapter.Factory): RetorfitConfig {
        callAdapterFactor.add(callFactor)
        return this
    }

    fun addConvertFactor(convertFactor:Converter.Factory): RetorfitConfig {
        convertFactors.add(convertFactor)
        return this
    }

    fun getCallAdapterFactors() = callAdapterFactor

    fun getConvertFactor() = convertFactors

}