package com.textile.client

import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex
import com.game.base.net.OkHttpConfig
import com.game.base.net.RxHttpUtil
import com.tencent.bugly.crashreport.CrashReport
import com.textile.client.login.model.UserPrefs
import com.textile.client.utils.AndroidUtils
import okhttp3.internal.Internal.instance

/**
 * Created by Administrator on 2019/1/5.
 */
class App:Application() {


    override fun onCreate() {
        super.onCreate()
        AndroidUtils.regCtx(this)
        CrashReport.initCrashReport(this, "5e17ae2b2a", BuildConfig.DEBUG)
        initHttpConfig()
    }

    private fun initHttpConfig() {
        val okHttpClientBuilder = OkHttpConfig.getInstance().Builder().setDebugMode(BuildConfig.DEBUG)

        RxHttpUtil.config().setClient(okHttpClientBuilder.build()).setBaseUrl("http://haroldchan.cn:8080/api/")
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}