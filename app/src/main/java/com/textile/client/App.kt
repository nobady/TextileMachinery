package com.textile.client

import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex
import com.game.base.net.OkHttpConfig
import com.game.base.net.RxHttpUtil
import com.tencent.bugly.crashreport.CrashReport

/**
 * Created by Administrator on 2019/1/5.
 */
class App:Application() {

    override fun onCreate() {
        super.onCreate()

        CrashReport.initCrashReport(this, "5e17ae2b2a", BuildConfig.DEBUG)
        initHttp()
    }

    private fun initHttp() {

        val headerMap = HashMap<String,String>()

        val okHttpClient = OkHttpConfig.getInstance().Builder().apply {
            isDebug = BuildConfig.DEBUG
            headMap = headerMap
        }.build()

        RxHttpUtil.config().setClient(okHttpClient).setBaseUrl("http://haroldchan.cn:8080/api/")
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}