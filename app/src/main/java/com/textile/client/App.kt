package com.textile.client

import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex
import com.game.base.net.RetrofitBuilder
import com.tencent.bugly.crashreport.CrashReport

/**
 * Created by Administrator on 2019/1/5.
 */
class App:Application() {

    override fun onCreate() {
        super.onCreate()

        CrashReport.initCrashReport(this, "5e17ae2b2a", BuildConfig.DEBUG)
        RetrofitBuilder.Builder().apply {
            baseUrl = ""
        }.build()
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}